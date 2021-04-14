create index IX_C0ECA4FC on AppBuilderModule (companyId);
create index IX_7B4D0AA0 on AppBuilderModule (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_388D00E6 on AppBuilderModuleEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_30C88E8 on AppBuilderModuleEntry (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_BBC1862F on AppBuilderModuleField (appBuilderModuleId);
create index IX_481F056E on AppBuilderModuleField (uuid_[$COLUMN_LENGTH:75$], companyId);