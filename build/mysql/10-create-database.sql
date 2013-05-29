-- Create dev database
CREATE DATABASE IF NOT EXISTS `quickstart`
  DEFAULT CHARACTER SET utf8
  COLLATE utf8_general_ci;

GRANT ALL PRIVILEGES ON quickstart.* TO 'quickstart'@'localhost'
IDENTIFIED BY 'quickstart'
WITH GRANT OPTION;

-- Create test database
CREATE DATABASE IF NOT EXISTS `quickstart_test`
  DEFAULT CHARACTER SET utf8
  COLLATE utf8_general_ci;

GRANT ALL PRIVILEGES ON quickstart_test.* TO 'quickstart'@'localhost'
WITH GRANT OPTION;
