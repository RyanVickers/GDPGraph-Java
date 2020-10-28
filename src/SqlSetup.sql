Create Database Ryan1111810;
use Ryan1111810;
Create Table grossDomesticProduct(
gdpId INT NOT NULL PRIMARY KEY auto_increment,
Year int(4),
quarter varchar(2),
gdpMarketValue int(20),
gdpDomesticValue int(20),
gdpPercentChange double(5,2)
);
INSERT INTO `Ryan1111810`.`grossDomesticProduct` (`Year`, `quarter`, `gdpMarketValue`, `gdpDomesticValue`, `gdpPercentChange`) VALUES ('2020', 'Q2', '1820369', '1817240', '-11.5');
INSERT INTO `Ryan1111810`.`grossDomesticProduct` (`Year`, `quarter`, `gdpMarketValue`, `gdpDomesticValue`, `gdpPercentChange`) VALUES ('2020', 'Q1', '2057186', '2043347', '-2.1');
INSERT INTO `Ryan1111810`.`grossDomesticProduct` (`Year`, `quarter`, `gdpMarketValue`, `gdpDomesticValue`, `gdpPercentChange`) VALUES ('2019', 'Q4', '2101480', '2083767', '0.1');
INSERT INTO `Ryan1111810`.`grossDomesticProduct` (`Year`, `quarter`, `gdpMarketValue`, `gdpDomesticValue`, `gdpPercentChange`) VALUES ('2019', 'Q3', '2098547', '2079684', '0.3');
INSERT INTO `Ryan1111810`.`grossDomesticProduct` (`Year`, `quarter`, `gdpMarketValue`, `gdpDomesticValue`, `gdpPercentChange`) VALUES ('2019', 'Q2', '2092705', '2063517', '0.8');
INSERT INTO `Ryan1111810`.`grossDomesticProduct` (`Year`, `quarter`, `gdpMarketValue`, `gdpDomesticValue`, `gdpPercentChange`) VALUES ('2019', 'Q1', '2076067', '2063110', '0.2');
INSERT INTO `Ryan1111810`.`grossDomesticProduct` (`Year`, `quarter`, `gdpMarketValue`, `gdpDomesticValue`, `gdpPercentChange`) VALUES ('2018', 'Q4', '2070133', '2046001', '0.3');
INSERT INTO `Ryan1111810`.`grossDomesticProduct` (`Year`, `quarter`, `gdpMarketValue`, `gdpDomesticValue`, `gdpPercentChange`) VALUES ('2018', 'Q3', '2065093', '2048909', '0.6');
INSERT INTO `Ryan1111810`.`grossDomesticProduct` (`Year`, `quarter`, `gdpMarketValue`, `gdpDomesticValue`, `gdpPercentChange`) VALUES ('2018', 'Q2', '2052613', '2047181', '0.4');
INSERT INTO `Ryan1111810`.`grossDomesticProduct` (`Year`, `quarter`, `gdpMarketValue`, `gdpDomesticValue`, `gdpPercentChange`) VALUES ('2018', 'Q1', '2044627', '2043194', '0.5');
INSERT INTO `Ryan1111810`.`grossDomesticProduct` (`Year`, `quarter`, `gdpMarketValue`, `gdpDomesticValue`, `gdpPercentChange`) VALUES ('2017', 'Q4', '2033577', '2037720', '0.4');
INSERT INTO `Ryan1111810`.`grossDomesticProduct` (`Year`, `quarter`, `gdpMarketValue`, `gdpDomesticValue`, `gdpPercentChange`) VALUES ('2017', 'Q3', '2024764', '2012052', '0.4');
INSERT INTO `Ryan1111810`.`grossDomesticProduct` (`Year`, `quarter`, `gdpMarketValue`, `gdpDomesticValue`, `gdpPercentChange`) VALUES ('2017', 'Q2', '2017569', '1992570', '1.2');
INSERT INTO `Ryan1111810`.`grossDomesticProduct` (`Year`, `quarter`, `gdpMarketValue`, `gdpDomesticValue`, `gdpPercentChange`) VALUES ('2017', 'Q1', '1994056', '1973495', '1.2');
