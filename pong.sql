-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 23, 2018 at 02:48 AM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pong`
--

-- --------------------------------------------------------

--
-- Table structure for table `GameMatch`
--

CREATE TABLE `GameMatch` (
  `game_id` int(11) NOT NULL,
  `match_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Games`
--

CREATE TABLE `Games` (
  `id` int(11) NOT NULL,
  `p1score` int(11) NOT NULL,
  `p2score` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Matches`
--

CREATE TABLE `Matches` (
  `id` int(11) NOT NULL,
  `player1_id` int(11) NOT NULL,
  `player2_id` int(11) NOT NULL,
  `stage` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Matches`
--

INSERT INTO `Matches` (`id`, `player1_id`, `player2_id`, `stage`) VALUES
(1, 3, 4, 1),
(2, 5, 6, 1),
(3, 7, 8, 1),
(7, 9, 10, 1);

-- --------------------------------------------------------

--
-- Table structure for table `MatchTournament`
--

CREATE TABLE `MatchTournament` (
  `match_id` int(11) NOT NULL,
  `tournament_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `MatchTournament`
--

INSERT INTO `MatchTournament` (`match_id`, `tournament_id`) VALUES
(0, 2),
(1, 2),
(2, 2),
(3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `Tournaments`
--

CREATE TABLE `Tournaments` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Tournaments`
--

INSERT INTO `Tournaments` (`id`, `name`) VALUES
(5, 'African Road to Glory'),
(1, 'American Wilderness'),
(4, 'Beijing Angle'),
(2, 'European Concrete'),
(3, 'Italia Datos'),
(6, 'World Tour');

-- --------------------------------------------------------

--
-- Table structure for table `Users`
--

CREATE TABLE `Users` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `isadmin` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Users`
--

INSERT INTO `Users` (`id`, `name`, `email`, `password`, `isadmin`) VALUES
(1, 'Test Guy', 'test@testus.com', 'sidetest', 0),
(2, 'Main Administrator', 'bogdanr@utcluj.ro', 'adminpass', 1),
(3, 'Florin Salam', 'fsalam@amma.ro', 'flo', 0),
(4, 'Nicolae Guta', 'ng@ro.ro', 'passguta', 0),
(5, 'Costel Ciofu', 'dwah@ajax.ro', 'wag', 0),
(6, 'Sorinel copilu', 'dagai@ghaiw.net', 'wagia', 0),
(7, 'DJ Sebi', 'diwah@jgpoa.ru', 'fawjg', 0),
(8, 'Dan Bursuc', 'dwag@pj.ne', 'fwoapj', 0),
(9, 'Paul Lica', 'dwaighi@caransebes.ro', 'dojwajg', 0),
(10, 'Gica Hagi', 'jjpij@jijg.net', 'opjj', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `GameMatch`
--
ALTER TABLE `GameMatch`
  ADD PRIMARY KEY (`game_id`,`match_id`);

--
-- Indexes for table `Games`
--
ALTER TABLE `Games`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Matches`
--
ALTER TABLE `Matches`
  ADD PRIMARY KEY (`id`),
  ADD KEY `p1_foreign` (`player1_id`),
  ADD KEY `p2_foreign` (`player2_id`);

--
-- Indexes for table `MatchTournament`
--
ALTER TABLE `MatchTournament`
  ADD PRIMARY KEY (`match_id`,`tournament_id`);

--
-- Indexes for table `Tournaments`
--
ALTER TABLE `Tournaments`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name_index` (`name`);

--
-- Indexes for table `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email_index` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Games`
--
ALTER TABLE `Games`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Matches`
--
ALTER TABLE `Matches`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `Tournaments`
--
ALTER TABLE `Tournaments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `Users`
--
ALTER TABLE `Users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Matches`
--
ALTER TABLE `Matches`
  ADD CONSTRAINT `p1_foreign` FOREIGN KEY (`player1_id`) REFERENCES `Users` (`id`),
  ADD CONSTRAINT `p2_foreign` FOREIGN KEY (`player2_id`) REFERENCES `Users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
