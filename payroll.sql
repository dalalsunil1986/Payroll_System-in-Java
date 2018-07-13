-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 15, 2018 at 01:38 PM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `payroll`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL,
  `adminid` varchar(256) NOT NULL,
  `password` varchar(256) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `adminid`, `password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `empid` varchar(255) NOT NULL,
  `empname` varchar(20) NOT NULL,
  `dob` varchar(50) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `contact` int(15) NOT NULL,
  `add1` varchar(50) NOT NULL,
  `add2` varchar(50) NOT NULL,
  `pincode` int(10) NOT NULL,
  `department` varchar(50) NOT NULL,
  `designation` varchar(50) NOT NULL,
  `datehired` varchar(50) NOT NULL,
  `salary` varchar(10000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`empid`, `empname`, `dob`, `gender`, `email`, `contact`, `add1`, `add2`, `pincode`, `department`, `designation`, `datehired`, `salary`) VALUES
('12', 'david', '22 march 1996', 'male', 'david@gmail.com', 1234567654, 'uk', 'london', 876778, 'Information technology', 'software eng', '12 aug 2007', '800'),
('13', 'rikki', '21 june 1778', 'male', 'rikki@gmail.com', 565433434, 'tottento', 'US', 765456, 'Accounts', 'Accounts Head', '15 may 2016', '1000'),
('1', 'sem', '12 march 1996', 'male', 'sem@gmail.com', 1234567876, 'uk', 'uk', 765654, 'IT', 'accounts', '21 june 2016', '800'),
('4', 'david', '12 june 1998', 'male', 'david@gmail.com', 1234567876, 'uk', 'london', 765654, 'IT', 'accounts', '23 march 2016', '800'),
('3', 'lara', '23 march 1887', 'female', 'lara@gmail.com', 1234567898, 'uk', 'torrento', 765676, 'CS', 'head', '22 june 2017', '799');

-- --------------------------------------------------------

--
-- Table structure for table `pay`
--

CREATE TABLE IF NOT EXISTS `pay` (
  `empid` varchar(255) NOT NULL,
  `empname` varchar(50) NOT NULL,
  `department` varchar(50) NOT NULL,
  `paydate` varchar(50) NOT NULL,
  `basic` varchar(10000) NOT NULL,
  `providedfund` varchar(10000) NOT NULL,
  `conveyance` varchar(10000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pay`
--

INSERT INTO `pay` (`empid`, `empname`, `department`, `paydate`, `basic`, `providedfund`, `conveyance`) VALUES
('12', '22 march 1996', 'software eng', '24 june 2017', '455', '655', '234'),
('4', '12 june 1998', 'accounts', '23 june 2017', '434', '545', '344'),
('3', '23 march 1887', 'head', '23 aug 2017', '543', '654', '466');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
