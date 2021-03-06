-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 27, 2017 at 09:15 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE DATABASE IF NOT EXISTS `tim55` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci */;
USE `tim55`;
--
-- Database: `tim55`
--

-- --------------------------------------------------------

--
-- Table structure for table `document`
--

CREATE TABLE `document` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `document_link` varchar(500) NOT NULL,
  `user_id` int(11) NOT NULL,
  `reviewer_id` int(11) DEFAULT NULL,
  `review` varchar(500) DEFAULT NULL,
  `is_approved` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `document`
--

INSERT INTO `document` (`id`, `name`, `document_link`, `user_id`, `reviewer_id`, `review`, `is_approved`) VALUES
(1, 'Teme SI', 'https://docs.google.com/document/d/1Re5X0-H_Mu_sEWvXvKYLtwnT1Lgqaz-p2s0zXCu8T4Q/edit', 2, NULL, NULL, 1),
(2, 'Senzori', 'https://docs.google.com/document/d/1iZf5sk7MumqJbQJJgChgaJMb5BGzHrCKdLofVxFqvDE/edit', 2, 3, NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `role_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `role_name`) VALUES
(1, 'Administator'),
(2, 'Registered user'),
(3, 'Reviewer');

-- --------------------------------------------------------

--
-- Table structure for table `speaker`
--

CREATE TABLE `speaker` (
  `id` int(11) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `cv` varchar(255) DEFAULT NULL,
  `image_link` varchar(255) NOT NULL,
  `info` varchar(1000) NOT NULL,
  `link` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `speaker`
--

INSERT INTO `speaker` (`id`, `first_name`, `last_name`, `cv`, `image_link`, `info`, `link`) VALUES
(1, 'Petar', 'Petrovic', NULL, 'http://cdn.zmescience.com/wp-content/uploads/2016/12/giraffe-912182_960_720.jpg', '\r\nNapomena:  \r\n ', 'https://www.youtube.com/watch?v=XgtopghkBZc '),
(2, 'Lela', 'Kesko', NULL, 'http://www.bioteams.com/images/the_networked_e.jpg', 'moje info', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `first_name` varchar(25) NOT NULL,
  `last_name` varchar(25) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `role_id` int(11) NOT NULL,
  `function` varchar(50) DEFAULT NULL,
  `note` varchar(100) DEFAULT NULL,
  `is_verified` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `password`, `city`, `state`, `role_id`, `function`, `note`, `is_verified`) VALUES
(1, 'Lejla', 'Kesko', 'lela.kesko@gmail.com', 'lelakesko1', 'Hadzici', 'Sarajevo', 1, NULL, 'pitajkonobara', 1),
(2, 'Imenko', 'Prezimenko', 'imenko.prezimenko@gmail.com', 'nemasifre1', NULL, NULL, 2, NULL, NULL, 1),
(3, 'Simba', 'Limba', 'simba.limba@gmail.com', 'simbalimba1', NULL, NULL, 3, NULL, NULL, 1),
(4, 'Adna', 'Karkelja', 'adna.karkelja@gmail.com', 'karkelja1', NULL, NULL, 3, NULL, NULL, 1),
(6, 'Proba', 'Registra', 'radi.li.ovo@gmail.com', 'radiliovo123', 'Travnik', 'BiH', 2, 'Student', 'Glup', 0),
(7, 'Proba', 'Registra2', 'radiliovo@gmail.com', 'radiliovo2', '', '', 2, '', '', 0),
(10, 'Reviewer', 'Prezime', 'nesto@gmail.com', 'nestooooo1', 'Nesto', 'Nesto', 3, 'nesto', '', 0),
(13, 'Lejla', 'Lejla', 'Lejla', 'lnestosifra', 'Lejla', 'Lejla', 3, 'Lejla', 'Lejla', 0),
(14, 'Admin', 'Admin', 'admin@gmail.com', 'admin1234', '', '', 1, '', 'SIAdmin', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `document`
--
ALTER TABLE `document`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`) USING BTREE,
  ADD KEY `reviewer_id` (`reviewer_id`) USING BTREE;

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `speaker`
--
ALTER TABLE `speaker`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_role_user` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `document`
--
ALTER TABLE `document`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `speaker`
--
ALTER TABLE `speaker`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `document`
--
ALTER TABLE `document`
  ADD CONSTRAINT `FK8m3chcomk0sj41ah2qfxfpt5w` FOREIGN KEY (`reviewer_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKjhdxdv9sijhujiynqbb5jc010` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `document_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `document_ibfk_2` FOREIGN KEY (`reviewer_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FKn82ha3ccdebhokx3a8fgdqeyy` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
