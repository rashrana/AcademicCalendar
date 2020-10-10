-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3325
-- Generation Time: Oct 10, 2020 at 07:59 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `calender`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `username` varchar(40) NOT NULL,
  `password` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`username`, `password`) VALUES
('deepen', '1234'),
('ichigo', 'rana'),
('kuroko', 'rana'),
('nisan', '12345'),
('nishan', 'giri'),
('pooja', 'potato'),
('prashant', 'rana'),
('rash', 'rana'),
('rashrana', '1234'),
('salina', 'gurung');

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE `events` (
  `Event` varchar(500) DEFAULT NULL,
  `Type` varchar(20) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Time` time(4) NOT NULL DEFAULT '08:00:00.0000'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `events`
--

INSERT INTO `events` (`Event`, `Type`, `Date`, `Time`) VALUES
('Mini Project Review', 'ASSIGNMENTS', '2020-04-28', '06:00:00.0000'),
('Buddha Purnima', 'FESTIVAL', '2020-05-07', '05:30:00.0000'),
('Mothers\' Day', 'FESTIVAL', '2020-04-23', '05:00:00.0000'),
('April Fools\' Day', 'FESTIVAL', '2020-04-01', '09:30:00.0000'),
('Volleyball Match', 'SPORTS', '2020-04-12', '15:00:00.0000'),
('NBA finals', 'SPORTS', '2020-05-29', '01:30:00.0000'),
('Sports Meet', 'SPORTS', '2020-05-01', '00:00:00.0000'),
('Placement Class', 'MEETINGS', '2020-05-10', '12:00:00.0000'),
('2nd CIE', 'MEETINGS', '2020-04-02', '06:00:00.0000'),
('CN Lab Exam', 'MEETINGS', '2020-05-27', '05:00:00.0000'),
('WORLD CUP 2022 START', 'SPORTS', '2022-11-21', '00:00:00.0000'),
('java lab exam', 'MEETINGS', '2020-05-27', '04:00:00.0000'),
('IDD', 'FESTIVAL', '2020-05-29', '21:30:00.0000'),
('NBA finals', 'SPORTS', '2020-05-19', '05:00:00.0000'),
('Mini Project Presentation', 'MEETINGS', '2020-08-11', '08:00:00.0000'),
('Krishna Janmastami', 'FESTIVAL', '2020-08-11', '09:00:00.0000'),
('Tanushs\' Birthday', 'FESTIVAL', '2020-08-08', '00:00:00.0000'),
('Football match', 'SPORTS', '2020-08-14', '05:30:00.0000'),
('interview', 'MEETINGS', '2020-09-15', '01:30:00.0000'),
('math assignments\n', 'ASSIGNMENTS', '2020-09-13', '00:00:00.0000');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
