create index IX_F4B21B3B on Oracly_Receivable (amount);
create index IX_4859A0A3 on Oracly_Receivable (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_6407F3E5 on Oracly_Receivable (uuid_[$COLUMN_LENGTH:75$], groupId);