-- with customer role:
INSERT INTO `form_login_test`.`users` (`idusers`, `email`, `fname`, `lname`, `pnumber`, `password`, `role`) VALUES ('1', 'user@email.it', 'mario', 'rossi', '123456789', '$2a$10$EOdB.YTvU/6nxrXhwr3fouJ2rHt5Riz0XQETugCPneRunwo4RwjVe', 'ROLE_CUSTOMER');
-- INSERT INTO `form_login_test`.`users` (`idusers`, `email`, `fname`, `lname`, `pnumber`, `password`, `role`) VALUES ('1', 'user@email.it', 'mario', 'rossi', '123456789', 'password', 'ROLE_CUSTOMER');

-- wiht manager role:
INSERT INTO `form_login_test`.`users` (`idusers`, `email`, `fname`, `lname`, `pnumber`, `password`, `role`) VALUES ('2', 'manager@email.it', 'fausto', 'rossi', '01230123', '$2a$10$EOdB.YTvU/6nxrXhwr3fouJ2rHt5Riz0XQETugCPneRunwo4RwjVe', 'ROLE_MANAGER');
