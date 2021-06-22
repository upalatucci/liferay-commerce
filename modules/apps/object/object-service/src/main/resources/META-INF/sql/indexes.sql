create index IX_54E11359 on ObjectDefinition (companyId, name[$COLUMN_LENGTH:75$], version);
create index IX_F6A157B1 on ObjectDefinition (companyId, objectDefinitionId);
create index IX_B929D94C on ObjectDefinition (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_139200BA on ObjectEntry (objectDefinitionId);
create index IX_49B9450D on ObjectEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_5AF9AACF on ObjectEntry (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_A59C5981 on ObjectField (objectDefinitionId, name[$COLUMN_LENGTH:75$]);
create index IX_594B4995 on ObjectField (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_E27AC523 on ObjectLayout (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_CDCBE8DC on ObjectLayoutBox (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_94D361A6 on ObjectLayoutTab (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_11DAE1F1 on ObjectRelationship (uuid_[$COLUMN_LENGTH:75$], companyId);