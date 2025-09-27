-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 27, 2025 at 02:02 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `blogdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `blogs`
--

CREATE TABLE `blogs` (
  `id` bigint(20) NOT NULL,
  `content` text DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `author_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `blogs`
--

INSERT INTO `blogs` (`id`, `content`, `created_at`, `title`, `updated_at`, `author_id`) VALUES
(29, 'In a world obsessed with productivity and optimization, every minute of our day is expected to have a purpose. We work, we exercise, we learn, we connect. Even our downtime is scheduled. We listen to a podcast on our walk to absorb new information, track our steps to meet a fitness goal, or mentally plan our next meeting.\n\nBut what about the value of doing something for no reason at all?\n\nThis is the art of the \'useless\' walk. A walk with no destination, no podcast, no fitness tracker, and no goal other than to simply walk. It’s a small act of rebellion against the non-stop demand to be productive.\n\nThe first few minutes feel strange. Your brain, accustomed to constant stimulation, might search for a task. But soon, it settles. You start to notice things you’d otherwise miss: the way the sunlight filters through the leaves of a tree, the intricate pattern on an old gate, the friendly nod of a stranger.\n\nThis purposeless wandering is where creativity often sparks. It’s when your mind is free to connect disparate ideas without pressure. It’s a form of active meditation that untangles mental knots and lowers the background hum of anxiety.\n\nSo, for your next break, try leaving your phone and your goals at home. Just step outside and walk. You might be surprised by what you find when you\'re not looking for anything at all.', '2025-09-27 11:44:43.000000', 'The Art of the \'Useless\' Walk', NULL, 8),
(30, 'The work week is done. The Saturday afternoon lull gives way to a specific kind of energy in Bengaluru. It’s the energy that pulls you out of your home and towards the nearest darshini. It’s the call of the 5 PM filter coffee.\n\nThere\'s a simple magic to it. The clatter of steel tumblers, the rich aroma of the chicory-laced brew, and that first sweet, scalding sip. It’s often paired with a crispy vada or a plate of fluffy idlis, a perfect snack to bridge the gap to dinner.\n\nThis isn\'t just about caffeine or food; it\'s a city-wide ritual. It’s a moment to pause, catch up with a friend, or just watch the world go by from a plastic chair. In a city that’s always rushing towards the future, this small tradition is a comforting, delicious anchor to the present.', '2025-09-27 11:46:06.000000', 'The Unbeatable Joy of a 5 PM Filter Coffee', NULL, 8),
(31, 'As the Saturday sun begins to set over our city, our screens usually stay bright. In a tech hub like Bengaluru, the line between connected and disconnected is perpetually blurred. We scroll through feeds, answer one last email, and queue up the next series.\n\nConsider this: a \"digital sunset.\" Just as the natural day ends, create a conscious endpoint for your screen time. It’s not about a full detox, but about creating a boundary. Decide that once evening truly sets in, the phones go down and the laptops close.\n\nThe benefits are immediate. Your mind gets a chance to wander without algorithmic guidance. You become more present for conversations with family. You might even pick up that book that’s been gathering dust. Tonight, as the sky changes colour, let your screens go dark with it.', '2025-09-27 11:47:52.000000', ' Is It Time for Your Digital Sunset?', NULL, 19),
(32, 'Bengaluru traffic on a Saturday evening can feel like a solid, unmoving beast. It\'s easy to feel enclosed by concrete and glass. But the spirit of the \"Garden City\" is resilient, and you don’t always have to go to Cubbon Park or Lalbagh to find it.\n\nLook for it in the small things. The determined bougainvillea spilling over a compound wall, painting a drab street with shocking pink. The single, majestic rain tree in a quiet lane that has survived decades of change. The small, lovingly-tended neighbourhood park where children’s laughter fills the air.\n\nThese pockets of green are vital sanctuaries. They are reminders that even in the heart of a bustling metropolis, nature holds its ground. The next time you feel overwhelmed by the urban grey, take a short walk and try to find the nearest patch of green. It’s almost always closer than you think.', '2025-09-27 11:48:19.000000', 'Finding the Green in the Grey', NULL, 19),
(33, 'The pressure to have a \"side hustle\" is real. Every hobby, it seems, must have the potential to be monetized or build your personal brand. But what if the most valuable project you could work on this weekend is one that’s completely and utterly \"useless\"?\n\nA useless project has no goal beyond the joy of its own creation. It’s about spending an hour trying to learn a new song on the guitar, not to perform it. It’s tending to your balcony plants without any plans to sell them. It\'s sketching in a notebook that no one else will ever see.\n\nThis is where true rest lies. By taking away the pressure of performance and productivity, you give your mind the freedom to play. That, in itself, is the most productive form of recharge for the week ahead.', '2025-09-27 11:48:46.000000', 'In Defence of the \"Useless\" Weekend Project', NULL, 19),
(34, 'Drive through any of the older areas of Bengaluru—Malleswaram, Jayanagar, Indiranagar—and you\'ll see them. The ghosts of old houses. You see a towering apartment complex and can almost picture the bungalow that stood there before: with a sloping red-tile roof, a wide veranda, and a garden full of mango and coconut trees.\n\nEach new glass facade represents progress, growth, and the city\'s relentless ambition. But it also marks the fading of a quieter, slower Bangalore. A Bangalore of close-knit lanes, afternoon naps undisturbed by construction, and the familiar scent of jasmine from a neighbour\'s garden.\n\nThis isn\'t a complaint against the new, but a quiet moment of appreciation for the old. The city\'s memory is held in the stories of those now-vanished homes, and it’s a heritage worth remembering.\n\n', '2025-09-27 11:50:01.000000', 'The Ghosts of Independent Houses', NULL, 18),
(35, 'There it is. Just as the day\'s warmth begins to recede, it arrives. That signature Bengaluru evening breeze.\n\nIt’s not a dramatic gust of wind, but a gentle, cool sigh that rustles the leaves and offers immediate relief. It’s one of the city’s most cherished and reliable pleasures. It turns a hot, stuffy room into a comfortable haven the moment you open a window.\n\nIt’s a simple thing, this breeze. It costs nothing and asks for nothing. All you have to do is pause, close your eyes, and feel it. It’s the city’s way of wishing you a good evening.', '2025-09-27 11:50:21.000000', ' That Bengaluru Evening Breeze', NULL, 18),
(36, 'You could be in a sleek, air-conditioned mall right now. But instead, you find yourself drawn to the beautiful chaos of a place like Malleswaram 8th Cross or Jayanagar 4th Block. This is where the city\'s pulse is most palpable on a Saturday evening.\n\nThe air is thick with the scent of fresh jasmine (mallige) and marigolds, piled high in fragrant mounds. Vendors call out prices in a rhythmic chant, their voices weaving into the symphony of the crowd. You navigate through a river of people, deftly sidestepping to admire colourful vegetables, stacks of clay pots, or glistening temple jewellery.\n\nThis isn’t just shopping; it’s a sensory immersion. It’s a negotiation, a conversation, a connection to the people who form the backbone of the city\'s commerce. In the organized chaos of the market, you find something far more vibrant and alive than in any quiet, curated store.', '2025-09-27 11:51:43.000000', 'The Beautiful Chaos of a Saturday Market', NULL, 18),
(37, 'Around this time on a Saturday, a specific kind of notification lights up phones across Bengaluru. It’s not from work, nor is it an automated reminder. It\'s the simple, hopeful message from a friend: \"Scenes tonight?\" or \"What\'s the plan?\"\n\nThis is the spark. It\'s the starting pistol for the evening\'s possibilities. What follows is a dance of modern social logistics—a flurry of suggestions on a group chat, the weighing of options between a new craft brewery and an old favourite pub, and the eventual, happy consensus that brings everyone together.\n\nMore than just a question about logistics, that text is a small but vital ritual of connection. It\'s a check-in, an invitation, a confirmation that you\'re part of a tribe. In that moment of anticipation, before any plan is even made, the promise of a shared night with friends is a joy all its own.', '2025-09-27 11:52:06.000000', 'The Art of the \"What\'s the Plan?\" Text', NULL, 18);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `name`, `password`) VALUES
(8, 'hello123@gmail.com', 'hello', '$2a$10$a7auPQr/LlJAwPIzUPOSj.G4Orq3cyHeGNFnqu/Y1Sjc6ktVzMmTq'),
(9, 'admin123@gmail.com', 'admin', '$2a$10$HNvJkOSFDAEFp9dWhcESyOfYsMCsG.KI3YlZWzWXtB8hIVEDI2Ca2'),
(10, 'hello1233@gmail.com', 'hello', '$2a$10$KWBYVoVtId5RiwInTYSKIOSsUhqQVDj4PmdDGm.FKhpI16V0UyeTe'),
(13, 'admin@example.com', 'User', '$2a$10$6diKYIppvP2KVpuE9guZxe7l.4Zo..HmbCrgzgCIZSEp35A3XnLhC'),
(17, 'maddy@gmail.com', 'maddy', '$2a$10$RpK49moNSZmCvE5M6To.Z.U3WB58LTGEe9CvS0Q74MFJGAm8EkgJG'),
(18, 'will1@gmail.com', 'will', '$2a$10$o.rT6iqLSIJ7eMO99JzYt.8uo2IxcR2L8AP1sDbzAgjDX0qRI3M1y'),
(19, 'aditya123@gmail.com', 'aditya', '$2a$10$qXidXNy.1g8uXqw/8XWp2uArs0NXU9/oml9HkExodxcdBlFt78pqC');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `blogs`
--
ALTER TABLE `blogs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKt8g0udj2fq40771g38t2t011n` (`author_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `blogs`
--
ALTER TABLE `blogs`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `blogs`
--
ALTER TABLE `blogs`
  ADD CONSTRAINT `FKt8g0udj2fq40771g38t2t011n` FOREIGN KEY (`author_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
