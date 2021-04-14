create table AppBuilderModule (
	uuid_ VARCHAR(75) null,
	appBuilderModuleId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	active_ BOOLEAN,
	name VARCHAR(75) null,
	label STRING null,
	dbTableName VARCHAR(75) null,
	dbTablePKColumnName VARCHAR(75) null,
	scope VARCHAR(75) null,
	resourceName VARCHAR(75) null,
	asset BOOLEAN,
	resource BOOLEAN,
	expando BOOLEAN
);

create table AppBuilderModuleEntry (
	uuid_ VARCHAR(75) null,
	appBuilderModuleEntryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	appBuilderModuleId LONG,
	lastPublishDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);

create table AppBuilderModuleField (
	uuid_ VARCHAR(75) null,
	appBuilderModuleFieldId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	appBuilderModuleId LONG,
	name VARCHAR(75) null,
	label STRING null,
	dbColumnName VARCHAR(75) null,
	type_ VARCHAR(75) null,
	typeSettings VARCHAR(75) null,
	nullable BOOLEAN
);