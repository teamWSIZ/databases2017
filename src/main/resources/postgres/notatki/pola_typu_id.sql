-- Próba 1: pole `fid` będzie automatycznie wstawiane, ale nie mamy tam unikalności, ani !null
-- CREATE table friends (
--   fid SERIAL,
--   name text,
--   rank int
-- ); --wersja z automatycznym polem typu ID, i z pilnowaniem by tam była wartość

-- INSERT into friends (name, rank) VALUES ('aa', 10);
-- INSERT into friends (fid, name, rank) VALUES (1, 'bb', 10); --drugi `1` --> źle!! tak nie chcemy
-- INSERT into friends (fid, name, rank) VALUES (NULL , 'aa', 10); -- to nie przejdzie -- OK, nie chcemy tam null-i
-- INSERT into friends (name, rank) VALUES ('aa', null); -- to przejdzie; OK, nie martwimy się tym

-- drop table friends;
--
-- Próba 2: pole `fid` będzie z definicji unikalne i indeksowane
CREATE table friends (
  fid SERIAL PRIMARY KEY,
  name text,
  rank int
); --dodatkowo pilnuje aby...

-- INSERT into friends (name, rank) VALUES ('aa', 10);
INSERT into friends (fid, name, rank) VALUES (1, 'bb', 10); --drugi `1` --> teraz nie przejdzie -- OK!
-- INSERT into friends (fid, name, rank) VALUES (NULL , 'aa', 10); -- to nie przejdzie -- OK, nie chcemy tam null-i
-- INSERT into friends (name, rank) VALUES ('aa', null); -- to przejdzie; OK, nie martwimy się tym
