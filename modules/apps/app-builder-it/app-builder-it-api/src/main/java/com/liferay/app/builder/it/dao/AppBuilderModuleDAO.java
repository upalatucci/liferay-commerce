package com.liferay.app.builder.it.dao;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.List;
import java.util.Optional;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface AppBuilderModuleDAO {

	Optional<JSONObject> get(long id) throws PortalException;

	List<JSONObject> getAll(long companyId, int[] statuses, int start, int end)
		throws PortalException;

	void save(JSONObject t) throws PortalException;

	void update(long id, JSONObject t) throws PortalException;

	void delete(JSONObject t);

}