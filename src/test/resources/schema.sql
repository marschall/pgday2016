CREATE TABLE IF NOT EXISTS demo_table (
  id               bigint NOT NULL,
  date_column      date,
  time_column      time(3),
  timestamp_column timestamp(3)
);