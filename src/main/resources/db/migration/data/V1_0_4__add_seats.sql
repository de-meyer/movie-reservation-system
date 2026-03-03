-- Generate seats for every theater.
-- Rows A–J (10 rows) × seats 1–10 = 100 seats per theater, matching the capacity column.
-- Seat names follow the pattern A1, A2, … J10.
INSERT INTO seats (theater_id, name, row_label, seat_number)
SELECT t.id,
       chr(64 + row_num) || seat_num::TEXT AS name,
       chr(64 + row_num)                   AS row_label,
       seat_num                            AS seat_number
FROM theater t
         CROSS JOIN generate_series(1, 10) AS row_num
         CROSS JOIN generate_series(1, 10) AS seat_num
ON CONFLICT (theater_id, name) DO NOTHING;

