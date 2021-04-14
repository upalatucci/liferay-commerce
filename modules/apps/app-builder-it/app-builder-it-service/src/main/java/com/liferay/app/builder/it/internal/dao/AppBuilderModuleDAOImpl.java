package com.liferay.app.builder.it.internal.dao;

import com.liferay.app.builder.it.dao.AppBuilderModuleDAO;
import com.liferay.app.builder.it.model.AppBuilderModuleEntryTable;
import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.DSLQueryFactoryUtil;
import com.liferay.petra.sql.dsl.expression.Expression;
import com.liferay.petra.sql.dsl.expression.Predicate;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.dao.jdbc.postgresql.PostgreSQLJDBCUtil;
import com.liferay.portal.dao.orm.common.SQLTransformer;
import com.liferay.portal.kernel.dao.jdbc.CurrentConnectionUtil;
import com.liferay.portal.kernel.dao.orm.Dialect;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.security.permission.InlineSQLHelper;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.TransactionConfig;
import com.liferay.portal.kernel.transaction.TransactionInvokerUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.math.BigDecimal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.sql.Types;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Callable;

import javax.sql.DataSource;

public class AppBuilderModuleDAOImpl implements AppBuilderModuleDAO {
	//TODO Implement fire of model listener
	//TODO I am not use in using JSON Object, feeel that a List<MAp<String,Object> is better

	public AppBuilderModuleDAOImpl(
		AppBuilderDynamicModuleTable appBuilderDynamicModuleTable, DataSource dataSource,
		boolean isResource, InlineSQLHelper inlineSQLHelper,
		JSONFactory jsonFactory, SessionFactory sessionFactory) {

		_appBuilderDynamicModuleTable = appBuilderDynamicModuleTable;
		_dataSource = dataSource;
		_isResource = isResource;
		_inlineSQLHelper = inlineSQLHelper;
		_jsonFactory = jsonFactory;
		_sessionFactory = sessionFactory;

		_dialect = _sessionFactory.getDialect();
	}

	@Override
	public void delete(JSONObject t) {
	}

	@Override
	public Optional<JSONObject> get(long id) throws PortalException {
		try {
			//TODO encapsulate the dao in a component that recive configurations, so we can implement AOPService and no need of use TransactionInvokerUtil

			return TransactionInvokerUtil.invoke(
				_transactionConfig,
				new Callable<Optional<JSONObject>>() {

					@Override
					public Optional<JSONObject> call() throws Exception {
						Session session = null;

						try {
							session = _sessionFactory.openSession();

							Expression<?>[] selectExpression =
								getSelectExpression();

							SQLQuery sqlQuery =
								session.createSynchronizedSQLQuery(
									DSLQueryFactoryUtil.selectDistinct(
										selectExpression
									).from(
										_appBuilderDynamicModuleTable
									).where(
										_appBuilderDynamicModuleTable.getPKColumn(
										).eq(
											id
										)
									));

							List<Object[]> rows =
								(List<Object[]>)QueryUtil.list(
									sqlQuery, _dialect, QueryUtil.ALL_POS,
									QueryUtil.ALL_POS);

							if ((rows == null) || rows.isEmpty()) {
								return Optional.empty();
							}

							Object[] objects = rows.get(0);

							JSONObject jsonObject =
								_jsonFactory.createJSONObject();

							for (int i = 0; i < selectExpression.length; i++) {
								Column column = (Column)selectExpression[i];

								_fillJSONObject(
									column.getJavaType(), column.getName(),
									objects[i], jsonObject);
							}

							return Optional.of(jsonObject);
						}
						catch (Exception exception) {
							throw new SystemException(exception);
						}
						finally {
							_sessionFactory.closeSession(session);
						}
					}

				});
		}
		catch (Throwable throwable) {
			throw new PortalException(throwable);
		}
	}

	@Override
	public List<JSONObject> getAll(
			long companyId, int[] statuses, int start, int end)
		throws PortalException {

		try {
			//TODO encapsulate the dao in a component that recive configurations, so we can implement AOPService and no need of use TransactionInvokerUtil

			return TransactionInvokerUtil.invoke(
				_transactionConfig,
				new Callable<List<JSONObject>>() {

					@Override
					public List<JSONObject> call() throws Exception {
						Session session = null;

						List<JSONObject> jsonObjects = new ArrayList<>();

						try {
							session = _sessionFactory.openSession();

							Predicate predicate =
								AppBuilderModuleEntryTable.INSTANCE.companyId.
									eq(companyId);

							if (!ArrayUtil.isEmpty(statuses)) {
								predicate = predicate.and(
									AppBuilderModuleEntryTable.INSTANCE.status.
										in(ArrayUtil.toArray(statuses)));
							}

							if (_isResource) {
								predicate.and(
									_inlineSQLHelper.
										getPermissionWherePredicate(
											_appBuilderDynamicModuleTable.getName(),
											_appBuilderDynamicModuleTable.
												getPKColumn()));
							}

							Expression<?>[] selectExpression =
								getSelectExpression();

							SQLQuery sqlQuery =
								session.createSynchronizedSQLQuery(
									DSLQueryFactoryUtil.selectDistinct(
										selectExpression
									).from(
										_appBuilderDynamicModuleTable
									).innerJoinON(
										AppBuilderModuleEntryTable.INSTANCE,
										AppBuilderModuleEntryTable.INSTANCE.
											appBuilderModuleEntryId.eq(
												_appBuilderDynamicModuleTable.
													getPKColumn())
									).where(
										predicate
									));

							List<Object[]> rows =
								(List<Object[]>)QueryUtil.list(
									sqlQuery, _dialect, start, end);

							for (Object[] objects : rows) {
								JSONObject jsonObject =
									_jsonFactory.createJSONObject();

								for (int i = 0; i < selectExpression.length;
									 i++) {

									Column column = (Column)selectExpression[i];

									_fillJSONObject(
										column.getJavaType(), column.getName(),
										objects[i], jsonObject);
								}
							}
						}
						catch (Exception exception) {
							throw new SystemException(exception);
						}
						finally {
							_sessionFactory.closeSession(session);
						}

						return jsonObjects;
					}

				});
		}
		catch (Throwable throwable) {
			throw new PortalException(throwable);
		}
	}

	@Override
	public void save(JSONObject t) throws PortalException {
		try {
			TransactionInvokerUtil.invoke(
				_transactionConfig,
				new Callable<Object>() {

					@Override
					public Object call() throws Exception {
						Connection connection =
							CurrentConnectionUtil.getConnection(_dataSource);

						Map<String, String> map = new HashMap<>();

						for (Column<AppBuilderDynamicModuleTable, ?> column :
								_appBuilderDynamicModuleTable.getColumns()) {

							if (t.has(column.getName())) {
								map.put(
									column.getName(),
									t.getString(column.getName()));
							}
						}

						Set<Map.Entry<String, String>> entries = map.entrySet();

						Iterator<Map.Entry<String, String>> itr =
							entries.iterator();

						String values = "";
						String columns = "";

						while (itr.hasNext()) {
							Map.Entry<String, String> entry = itr.next();

							columns += entry.getKey();
							values += "?";

							if (itr.hasNext()) {
								columns += StringPool.COMMA;
								values += StringPool.COMMA;
							}
						}

						StringBundler sb = new StringBundler(7);

						sb.append("insert into ");
						sb.append(_appBuilderDynamicModuleTable.getName());
						sb.append(" ( ");
						sb.append(columns);
						sb.append(" ) VALUES ( ");
						sb.append(values);
						sb.append(" )");

						String sql = sb.toString();

						sql = SQLTransformer.transform(sql.trim());

						try (PreparedStatement ps = connection.prepareStatement(
								sql)) {

							int i = 1;

							for (Map.Entry<String, String> entry : entries) {
								Column column =
									_appBuilderDynamicModuleTable.getColumn(
										entry.getKey());

								setColumn(
									ps, i, column.getSQLType(),
									entry.getValue());

								i++;
							}

							ps.executeUpdate();
						}

						return true;
					}

				});
		}
		catch (Throwable throwable) {
			throw new PortalException(throwable);
		}
	}

	public void setColumn(
			PreparedStatement ps, int index, Integer type, String value)
		throws Exception {

		int t = type.intValue();

		int paramIndex = index + 1;

		if (t == Types.BIGINT) {
			ps.setLong(paramIndex, GetterUtil.getLong(value));
		}
		else if ((t == Types.BLOB) || (t == Types.LONGVARBINARY)) {
			if (PostgreSQLJDBCUtil.isPGStatement(ps)) {
				PostgreSQLJDBCUtil.setLargeObject(
					ps, paramIndex, Base64.decode(value));
			}
			else {
				ps.setBytes(paramIndex, Base64.decode(value));
			}
		}
		else if (t == Types.BOOLEAN) {
			ps.setBoolean(paramIndex, GetterUtil.getBoolean(value));
		}
		else if ((t == Types.CLOB) || (t == Types.LONGVARCHAR) ||
				 (t == Types.VARCHAR)) {

			value = StringUtil.replace(
				value, _SAFE_TABLE_CHARS[1], _SAFE_TABLE_CHARS[0]);

			ps.setString(paramIndex, value);
		}
		else if (t == Types.DECIMAL) {
			ps.setBigDecimal(
				paramIndex, (BigDecimal)GetterUtil.get(value, BigDecimal.ZERO));
		}
		else if (t == Types.DOUBLE) {
			ps.setDouble(paramIndex, GetterUtil.getDouble(value));
		}
		else if (t == Types.FLOAT) {
			ps.setFloat(paramIndex, GetterUtil.getFloat(value));
		}
		else if (t == Types.INTEGER) {
			ps.setInt(paramIndex, GetterUtil.getInteger(value));
		}
		else if (t == Types.SMALLINT) {
			ps.setShort(paramIndex, GetterUtil.getShort(value));
		}
		else if (t == Types.TIMESTAMP) {
			if (StringPool.NULL.equals(value)) {
				ps.setTimestamp(paramIndex, null);
			}
			else {
				DateFormat df = DateUtil.getISOFormat();

				Date date = df.parse(value);

				ps.setTimestamp(paramIndex, new Timestamp(date.getTime()));
			}
		}
		else if (t == Types.TINYINT) {
			ps.setShort(paramIndex, GetterUtil.getShort(value));
		}
	}

	@Override
	public void update(long id, JSONObject t) throws PortalException {
		try {
			TransactionInvokerUtil.invoke(
				_transactionConfig,
				new Callable<Object>() {

					@Override
					public Object call() throws Exception {
						Connection connection =
							CurrentConnectionUtil.getConnection(_dataSource);

						Map<String, String> map = new HashMap<>();

						for (Column<AppBuilderDynamicModuleTable, ?> column :
								_appBuilderDynamicModuleTable.getColumns()) {

							if (t.has(column.getName())) {
								map.put(
									column.getName(),
									t.getString(column.getName()));
							}
						}

						Set<Map.Entry<String, String>> entries = map.entrySet();

						Iterator<Map.Entry<String, String>> itr =
							entries.iterator();

						StringBundler sb = new StringBundler();

						sb.append("update " + _appBuilderDynamicModuleTable.getName());
						sb.append(" set ");

						while (itr.hasNext()) {
							Map.Entry<String, String> entry = itr.next();

							sb.append(entry.getKey() + " = ?");

							if (itr.hasNext()) {
								sb.append(StringPool.COMMA);
							}
						}

						Column pkColumn = _appBuilderDynamicModuleTable.getPKColumn();

						sb.append(" WHERE " + pkColumn.getName() + " = ?");

						try (PreparedStatement ps = connection.prepareStatement(
								sb.toString())) {

							int i = 1;

							for (Map.Entry<String, String> entry : entries) {
								Column column =
									_appBuilderDynamicModuleTable.getColumn(
										entry.getKey());

								setColumn(
									ps, i, column.getSQLType(),
									entry.getValue());

								i++;
							}

							ps.setLong(i, id);

							ps.executeUpdate();
						}

						return true;
					}

				});
		}
		catch (Throwable throwable) {
			throw new PortalException(throwable);
		}
	}

	private void _fillJSONObject(
		Class clazz, String key, Object object, JSONObject jsonObject) {

		if (clazz == String.class) {
			jsonObject.put(key, (String)object);
		}
		else if (clazz == Boolean.class) {
			jsonObject.put(key, (Boolean)object);
		}
		else if (clazz == Date.class) {
			jsonObject.put(key, (Date)object);
		}
		else if (clazz == Long.class) {
			Number number = (Number)object;

			jsonObject.put(key, number.longValue());
		}
		else if (clazz == Integer.class) {
			Number number = (Number)object;

			jsonObject.put(key, number.intValue());
		}
		else if (clazz == Double.class) {
			Number number = (Number)object;

			jsonObject.put(key, number.doubleValue());
		}
		else if (clazz == Float.class) {
			Number number = (Number)object;

			jsonObject.put(key, number.floatValue());
		}
		else if (clazz == Short.class) {
			Number number = (Number)object;

			jsonObject.put(key, number.shortValue());
		}
		else if (clazz == BigDecimal.class) {
			jsonObject.put(key, (BigDecimal)object);
		}
		else if (clazz == Timestamp.class) {
			jsonObject.put(key, (Timestamp)object);
		}
	}

	private Expression<?>[] getSelectExpression() {
		Set<Expression<?>> expressions = new HashSet<>();

		for (Column<AppBuilderDynamicModuleTable, ?> column :
				_appBuilderDynamicModuleTable.getColumns()) {

			expressions.add(column);
		}

		Expression<?>[] array = new Expression<?>[expressions.size()];

		return expressions.toArray(array);
	}

	private static final String[][] _SAFE_TABLE_CHARS = {
		{StringPool.COMMA, StringPool.NEW_LINE, StringPool.RETURN},
		{
			AppBuilderModuleDAOImpl._SAFE_TABLE_COMMA_CHARACTER,
			AppBuilderModuleDAOImpl._SAFE_TABLE_NEWLINE_CHARACTER,
			AppBuilderModuleDAOImpl._SAFE_TABLE_RETURN_CHARACTER
		}
	};

	private static final String _SAFE_TABLE_COMMA_CHARACTER =
		"_SAFE_TABLE_COMMA_CHARACTER_";

	private static final String _SAFE_TABLE_NEWLINE_CHARACTER =
		"_SAFE_TABLE_NEWLINE_CHARACTER_";

	private static final String _SAFE_TABLE_RETURN_CHARACTER =
		"_SAFE_TABLE_RETURN_CHARACTER_";

	private static final TransactionConfig _transactionConfig =
		TransactionConfig.Factory.create(
			Propagation.REQUIRED, new Class<?>[] {Exception.class});

	private final AppBuilderDynamicModuleTable _appBuilderDynamicModuleTable;
	private final DataSource _dataSource;
	private final Dialect _dialect;
	private final InlineSQLHelper _inlineSQLHelper;
	private final boolean _isResource;
	private final JSONFactory _jsonFactory;
	private final SessionFactory _sessionFactory;

}