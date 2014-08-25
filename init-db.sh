#!/bin/bash

function createdb() {
  DATABASE=$1
  PGPASSWORD=postgres psql -U postgres -h localhost -c "drop database ${DATABASE}"
  PGPASSWORD=postgres psql -U postgres -h localhost -c "create database ${DATABASE}"
  PGPASSWORD=postgres printf "\\c ${DATABASE}\ncreate table todo_items ( description varchar(255), dueDate date );\n" | psql -U postgres
}

createdb "transactionssample"
