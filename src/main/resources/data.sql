-- Insert theaters
INSERT INTO theater (id, name, capacity)
VALUES ('b1a2c3d4-e5f6-7890-ab12-cd34ef56ab78', 'Atmos', 100),
       ('f7e6d5c4-b3a2-1908-7654-3210fedcba98', 'Mpeg-4', 100),
       ('123e4567-e89b-12d3-a456-426614174000', 'Explicite', 100),
       ('9f8e7d6c-5b4a-3c2d-1e0f-9a8b7c6d5e4f', 'Old', 100),
       ('0a1b2c3d-4e5f-6789-abcd-ef0123456789', '4-D', 100),
       ('abcdefab-cdef-abcd-efab-cdefabcdefab', 'Big Room', 100)
ON CONFLICT (id) DO NOTHING;

-- Insert movies
INSERT INTO movies (id, title, description, release_year, director, genre, duration_minutes, image_profile,
                    image_landscape)
VALUES ('cab1370c-e8e9-423f-bce0-8d13322e55eb', 'Fast & Flurrious: Drifted in IKEA',
        'Vin Diesel but make it Swedish and lost in aisle 12. Zoom zoom but flatpack.', 2022, 'Hans Meatball', 'Action',
        119, 'fast_and_flurious-profile.jpg', 'fast_and_flurious-landscape.jpg'),
       ('986ace32-7d3e-4cc7-ba5a-eec52b50a505', 'ShrekTok: The Rise of Swampfluencers',
        'Shrek becomes a viral sensation on TikTok. Donkey''s starting a podcast.', 2024, 'Memelord Studios', 'Comedy',
        102, 'shrektok-profile.jpg', 'shrektok-landscape.jpg'),
       ('e5f3c041-8dd6-4197-8d56-5d6cb5e1496e', 'Among Us: The Movie (Sussy Edition)',
        'Red was sus. Now he''s in jail. Plot twist: He was the janitor.', 2021, 'Impostor Vibes', 'Thriller', 91,
        'among_us-profile.jpg', 'among_us-landscape.jpg'),
       ('ceb9370c-e8e9-423f-bce0-8d13322e55eb', 'LORD OF THE REEEs',
        'A frog with a dream. One ring. Endless screaming.', 2020, 'Kermit V', 'Fantasy', 140,
        'lord_of_the_rees-profile.jpg', 'lord_of_the_rees-landscape.jpg'),
       ('e4f3c041-8dd6-4197-8d56-5d6cb5e1496e', 'Zoom High School Musical',
        'They''re all in this laggy Zoom call together. Buffering has never been so dramatic.', 2020, 'Troy Lagborn',
        'Musical', 97, 'zoom_highschool-profile.jpg', 'zoom_highschool-landscape.jpg'),
       ('987ace32-7d3e-4cc7-ba5a-eec52b50a505', 'Karen: The Final Refund',
        'She asked for the manager... and got revenge.', 2023, 'Chad Cashier', 'Horror', 88, 'karen-profile.jpg',
        'karen-landscape.jpg'),
       ('ceb9370c-e8e9-423f-bce0-8d13322e11eb', 'The Chronicles of Naania',
        'They opened the fridge... and entered a land of spicy carbs and mystical dips.', 2019, 'Dip Patel', 'Fantasy',
        113, 'naania-profile.jpg', 'naania-landscape.jpg'),
       ('c4f3c041-8dd6-4197-8d56-8d6cb5e1496e', 'The Bored of the Rings',
        'Same story, but Frodo''s tired and Gandalf forgot his lines.', 2023, 'Sir Procrastino', 'Parody', 122,
        'bored-profile.jpg', 'bored-landscape.jpg'),
       ('13f3c041-8dd6-4197-8d56-5d6cb5e1496e', 'Slay Another Day',
        'James Bond but with eyeliner and a ring light. Serving spy realness.', 2024, 'Fierce McQueen', 'Action', 108,
        'slay-profile.jpg', 'slay-landscape.jpg'),
       ('23f3c041-8dd6-4197-8d56-5d6cb5e1496e', 'Fifty Shades of Ehh',
        'A romcom where nothing happens and everyone''s just... vibing.', 2018, 'Indie Cringe', 'Romance', 89,
        'fifty_shades_of_Ehh-profile.jpg', 'fifty_shades_of_Ehh-landscape.jpg'),
       ('33f3c041-8dd6-2199-8d56-5d6cb5e1496e', 'Yeet of the Jedi', 'The Force? Nah fam, we YEET.', 2023,
        'Obi-Wan KenVobi', 'Sci-Fi', 115, 'yeet_of_jedi-profile.jpg', 'yeet_of_jedi-landscape.jpg'),
       ('43f3c041-8dd6-4197-8d56-5d6cb5e1496e', 'The Simping Dead',
        'Zombies, but instead of brains, they crave validation.', 2021, 'Rick Swole', 'Horror', 106,
        'simping_dead-profile.jpg', 'simping_dead-landscape.jpg'),
       ('53f3c041-8dd6-4197-8d56-5d6cb5e1496e', 'Breaking Bread',
        'A chemistry teacher opens a bakery empire. Crumbs incoming.', 2022, 'Walter Whitebread', 'Drama', 112,
        'breaking_bread-profile.jpg', 'breaking_bread-landscape.jpg'),
       ('63f3c041-8dd6-4197-8d56-5d6cb5e1496e', 'Finding Emo',
        'A sad fish in skinny jeans writes poetry at the bottom of the ocean.', 2017, 'Tim Burtonfish', 'Animated', 94,
        'finding_emo-profile.jpg', 'finding_emo-landscape.jpg'),
       ('73f3c041-8dd6-4197-8d56-5d6cb5e1496e', 'WAP: Wizards and Potions',
        'A Hogwarts spinoff where spells slap and potions hit diff.', 2024, 'Cardi Pottah', 'Fantasy', 110,
        'wizards-profile.jpg', 'wizards-landscape.jpg'),
       ('83f3c041-8dd6-4197-8d56-5d6cb5e1496e', 'No Thoughts, Just Vibes',
        'Nothing happens. Everyone just sits around. Deeply therapeutic.', 2020, 'Chillax Daniels', 'Experimental', 99,
        'no_thoughts-profile.jpg', 'no_thoughts-landscape.jpg'),
       ('f3f3c041-8dd6-4197-8d56-5d6cb5e1496e', 'Meowtrix: Fur Loaded',
        'Neo is a cat now. He paws the red pill. Reality collapses.', 2021, 'Fluffy Wachowsky', 'Sci-Fi', 117,
        'meowtrix-profile.jpg', 'meowtrix-landscape.jpg'),
       ('e3f3c041-8dd6-4197-8d56-5d6cb5e1496e', 'Barbenheimer 2: Nuclear Slay',
        'She''s pretty. He''s atomic. Together they''re causing mushroom cloud drama.', 2025, 'Greta Nolan', 'Action',
        129, 'barbenheimer-profile.jpg', 'barbenheimer-landscape.jpg'),
       ('d3f3c041-8dd6-4197-8d56-5d6cb5e1496e', 'Ratatootie',
        'A rat that controls your cooking AND farts on command. Bon appétit and gaslight.', 2022, 'Chef Boyardee',
        'Animated', 96, 'ratatooote-profile.jpg', 'ratatooote-landscape.jpg'),
       ('c3f3c041-8dd6-4197-8d56-5d6cb5e1496e', 'The Notebook.exe',
        'A love story between a girl and a sentient Excel spreadsheet. Love cells = A1:A2.', 2021,
        'Spreadsheet Spielberg', 'Rom-Com', 98, 'the_notebook-profile.jpg', 'the_notebook-landscape.jpg'),
       ('b3f3c041-8dd6-4197-8d56-5d6cb5e1496e', 'Swipe Left for Doom',
        'A dating app that matches you with the Grim Reaper. Ghosted? Literally.', 2023, 'Tinderella', 'Horror', 89,
        'swipe-profile.jpg', 'swipe-landscape.jpg'),
       ('a3f3c041-8dd6-4197-8d56-5d6cb5e1496e', 'Dune: Sand But Make It Fashion',
        'Timothée returns, but this time the worms walk the runway.', 2024, 'Dennis Blingeneuve', 'Sci-Fi', 132,
        'dune-profile.jpg', 'dune-landscape.jpg'),
       ('b2f3c041-8dd6-4197-8d56-5d6cb5e1496e', 'GigaChad Origins',
        'Before the jawline, before the flex — there was pain, and creatine.', 2020, 'Chad Brosef IV', 'Documentary',
        83, 'gigachad-profile.jpg', 'gigachad-landscape.jpg'),
       ('3ff3c041-8dd6-4197-8d56-5d6cb5e1496e', 'WALL-E-Girl',
        'She collects trash. He is trash. Match made in dystopia.', 2023, 'PixYass', 'Animated', 101,
        'wall_E-profile.jpg', 'wall_E-landscape.jpg'),
       ('caf3c041-8dd6-4197-8d56-5d6cb5e1496e', 'The Grinch Who Stole My Vibe',
        'He didn''t just steal Christmas. He unfollowed you and subtweeted.', 2021, 'Green Gobsmack', 'Holiday', 90,
        'grinch-profile.jpg', 'grinch-landscape.jpg'),
       ('fff3c041-8dd6-4197-8d56-5d6cb5e1496e', 'Netflix and Kill',
        'A slasher who only strikes during chill sessions. Binge carefully.', 2022, 'Chill E. Murda', 'Horror', 93,
        'netflix-profile.jpg', 'netflix-landscape.jpg'),
       ('93f3c041-8dd6-4197-8d56-5d6cb5e1496e', 'NPCs: The Untold Lore',
        'They walk into walls. They repeat the same line. Now we know why.', 2023, 'Todd Dialoguetree', 'Mockumentary',
        99, 'npc-profile.jpg', 'npc-landscape.jpg')
ON CONFLICT (id) DO NOTHING;

-- tomorrow shows
-- Insert shows for Karen: The Final Refund
INSERT INTO shows (id, movie_id, theater_id, date)
VALUES ('3a2b3c4d-5a6f-7a8b-9c0d-1e2f3a4b5c6d', '987ace32-7d3e-4cc7-ba5a-eec52b50a505',
        '9f8e7d6c-5b4a-3c2d-1e0f-9a8b7c6d5e4f', '2025-10-02 09:00:00+00'),
       ('4a2b3c4d-5b6f-7a8b-9c0d-1e2f3a4b5c6d', '987ace32-7d3e-4cc7-ba5a-eec52b50a505',
        '9f8e7d6c-5b4a-3c2d-1e0f-9a8b7c6d5e4f', '2025-10-02 10:45:00+00'),
       ('5a2b3c4d-5c6f-7a8b-9c0d-1e2f3a4b5c6d', '987ace32-7d3e-4cc7-ba5a-eec52b50a505',
        '9f8e7d6c-5b4a-3c2d-1e0f-9a8b7c6d5e4f', '2025-10-02 12:30:00+00'),
       ('6a2b3c4d-5d6f-7a8b-9c0d-1e2f3a4b5c6d', '987ace32-7d3e-4cc7-ba5a-eec52b50a505',
        'f7e6d5c4-b3a2-1908-7654-3210fedcba98', '2025-10-02 16:00:00+00'),
       ('7a2b3c4d-5d6f-7b8b-9c0d-1e2f3a4b5c6d', '987ace32-7d3e-4cc7-ba5a-eec52b50a505',
        'f7e6d5c4-b3a2-1908-7654-3210fedcba98', '2025-10-02 17:45:00+00'),
       ('8a2b3c4d-5d6f-7c8b-9c0d-1e2f3a4b5c6d', '987ace32-7d3e-4cc7-ba5a-eec52b50a505',
        'f7e6d5c4-b3a2-1908-7654-3210fedcba98', '2025-10-02 19:00:00+00'),

-- Insert shows for GigaChad Origins
       ('1a2c9e2a-7b4d-7a53-9c2e-8d6f5a1b2c3d', 'b2f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'b1a2c3d4-e5f6-7890-ab12-cd34ef56ab78', '2025-10-02 09:30:00+00'),
       ('1b3c9e2a-7b4d-7a53-9c2e-8d6f5a1b2c3d', 'b2f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'b1a2c3d4-e5f6-7890-ab12-cd34ef56ab78', '2025-10-02 12:00:00+00'),
       ('1c4c9e2a-7b4d-7a53-9c2e-8d6f5a1b2c3d', 'b2f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'b1a2c3d4-e5f6-7890-ab12-cd34ef56ab78', '2025-10-02 14:30:00+00'),
       ('1d5c9e2a-7b4d-7a53-9c2e-8d6f5a1b2c3d', 'b2f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '0a1b2c3d-4e5f-6789-abcd-ef0123456789', '2025-10-02 16:45:00+00'),
       ('1e6c9e2a-7b4d-7a53-9c2e-8d6f5a1b2c3d', 'b2f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '0a1b2c3d-4e5f-6789-abcd-ef0123456789', '2025-10-02 19:15:00+01'),
       ('1f7c9e2a-7b4d-7a53-9c2e-8d6f5a1b2c3d', 'b2f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '0a1b2c3d-4e5f-6789-abcd-ef0123456789', '2025-10-02 21:45:00+00'),

-- Insert shows for Meowtrix: Fur Loaded
       ('3a7e6d4c-1a3f-4c2c-9d5e-6f7a8b9c0d1e', 'f3f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '123e4567-e89b-12d3-a456-426614174000', '2025-10-02 15:00:00+00'),
       ('3b7e6d4c-1a3f-4d2c-9d5e-6f7a8b9c0d1e', 'f3f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '123e4567-e89b-12d3-a456-426614174000', '2025-10-02 16:45:00+00'),

-- Insert shows for Swipe Left for Doom
       ('3f1c9e2a-7b4d-4a53-9c2e-1d6f5a1b2c3d', 'b3f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'abcdefab-cdef-abcd-efab-cdefabcdefab', '2025-10-02 13:00:00+00'),
       ('6a2d4f9b-5c1e-4f3a-8b7d-2e0f1a2b3c4d', 'b3f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'abcdefab-cdef-abcd-efab-cdefabcdefab', '2025-10-02 15:30:00+00'),

-- Insert shows for Netflix and Bequiet
       ('8c3d5b7a-2f1e-4c9b-8a6d-5b2c3d4e5f6a', 'fff3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '123e4567-e89b-12d3-a456-426614174000', '2025-10-02 11:00:00+00'),
       ('9d4a7b6c-3e2f-4a1b-9c8d-6e6f5a4b3c2d', 'fff3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '123e4567-e89b-12d3-a456-426614174000', '2025-10-02 13:00:00+00'),
       ('f1e2d3c4-b5a6-4f7e-8d9c-9a1b2c3d4e5f', 'fff3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '0a1b2c3d-4e5f-6789-abcd-ef0123456789', '2025-10-02 09:45:00+00'),
       ('f2e2d3c4-b5a6-4f7e-8d9c-2a1b2c3d4e5f', 'fff3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '0a1b2c3d-4e5f-6789-abcd-ef0123456789', '2025-10-02 11:45:00+00'),

-- Insert shows for WALL-E-Girl
       ('b3d4d5e6-f7a8-4b9c-8d1e-2f3a4b5c6d7e', '3ff3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'b1a2c3d4-e5f6-7890-ab12-cd34ef56ab78', '2025-10-02 17:00:00+00'),
       ('c4e5e6f7-a8b9-4c0d-8e2f-3a4b5c6d7e8f', '3ff3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'b1a2c3d4-e5f6-7890-ab12-cd34ef56ab78', '2025-10-02 19:00:00+00'),
       ('c5f5e6f7-a8b9-4c0d-8e2f-3a4b5c6d7e8f', '3ff3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'abcdefab-cdef-abcd-efab-cdefabcdefab', '2025-10-02 09:00:00+00'),
       ('c6a5e6f7-a8b9-4c0d-8e2f-3a4b5c6d7e8f', '3ff3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'abcdefab-cdef-abcd-efab-cdefabcdefab', '2025-10-02 11:00:00+00'),

-- Insert shows for NPCs: The Untold Lore
       ('d516f7a8-b9c0-4d1e-8f3a-4b5c6d7e8f90', '93f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'f7e6d5c4-b3a2-1908-7654-3210fedcba98', '2025-10-02 09:00:00+00'),
       ('e627a8b9-c0d1-4e2f-8a4b-5c6d7e8f901e', '93f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'f7e6d5c4-b3a2-1908-7654-3210fedcba98', '2025-10-02 11:00:00+00'),
       ('f738b9c0-d1e2-4f3a-8b5c-6d7e8f901234', '93f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'f7e6d5c4-b3a2-1908-7654-3210fedcba98', '2025-10-02 13:00:00+00'),
       ('01434567-89ab-4cde-8f01-23456789abcd', '93f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'abcdefab-cdef-abcd-efab-cdefabcdefab', '2025-10-02 18:00:00+00'),

-- Insert shows for No Thoughts, Just Vibes
       ('895bcdef-0123-4a56-8b8c-9d0e1f2a3b4c', '83f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '123e4567-e89b-12d3-a456-426614174000', '2025-10-02 09:00:00+00'),
       ('ab6def01-2345-4b67-8c9d-0e1f2a3b4c5d', '83f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '123e4567-e89b-12d3-a456-426614174000', '2025-10-02 18:30:00+00'),
       ('897bcdef-0123-4a56-8b8c-9d0e1f2a3b4c', '83f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '9f8e7d6c-5b4a-3c2d-1e0f-9a8b7c6d5e4f', '2025-10-02 14:15:00+00'),
       ('ab8def01-2345-4b67-8c9d-0e1f2a3b4c5d', '83f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '9f8e7d6c-5b4a-3c2d-1e0f-9a8b7c6d5e4f', '2025-10-02 16:00:00+00'),

-- Insert shows for Breaking Bread
       ('1cdef012-3456-4c78-9d0e-1f2a3b4c5d6e', '53f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'b1a2c3d4-e5f6-7890-ab12-cd34ef56ab78', '2025-10-02 21:00:00+00'),
       ('2def0123-4567-4d89-8e1f-2a3b4c5d6e7f', '53f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'abcdefab-cdef-abcd-efab-cdefabcdefab', '2025-10-02 20:00:00+00')
ON CONFLICT (id) DO NOTHING;
-- today shows
-- Insert shows for Finding Emo
INSERT INTO shows (id, movie_id, theater_id, date)
VALUES ('1a2b3c4d-5a6f-7a8b-9c0d-1e2f3a4b5c6d', '63f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '9f8e7d6c-5b4a-3c2d-1e0f-9a8b7c6d5e4f', '2025-10-01 09:00:00+00'),
       ('1a2b3c4d-5b6f-7a8b-9c0d-1e2f3a4b5c6d', '63f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '9f8e7d6c-5b4a-3c2d-1e0f-9a8b7c6d5e4f', '2025-10-01 10:45:00+00'),
       ('1a2b3c4d-5c6f-7a8b-9c0d-1e2f3a4b5c6d', '63f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '9f8e7d6c-5b4a-3c2d-1e0f-9a8b7c6d5e4f', '2025-10-01 12:30:00+00'),
       ('1a2b3c4d-5d6f-7a8b-9c0d-1e2f3a4b5c6d', '63f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'f7e6d5c4-b3a2-1908-7654-3210fedcba98', '2025-10-01 16:00:00+00'),
       ('1a2b3c4d-5d6f-7b8b-9c0d-1e2f3a4b5c6d', '63f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'f7e6d5c4-b3a2-1908-7654-3210fedcba98', '2025-10-01 19:45:00+00'),
       ('1a2b3c4d-5d6f-7c8b-9c0d-1e2f3a4b5c6d', '63f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'f7e6d5c4-b3a2-1908-7654-3210fedcba98', '2025-10-01 21:00:00+00'),

-- Insert shows for Barbenheimer 2
       ('1a1c9e2a-7b4d-7a53-9c2e-8d6f5a1b2c3d', 'e3f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'b1a2c3d4-e5f6-7890-ab12-cd34ef56ab78', '2025-10-01 09:30:00+00'),
       ('1b1c9e2a-7b4d-7a53-9c2e-8d6f5a1b2c3d', 'e3f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'b1a2c3d4-e5f6-7890-ab12-cd34ef56ab78', '2025-10-01 12:00:00+00'),
       ('1c1c9e2a-7b4d-7a53-9c2e-8d6f5a1b2c3d', 'e3f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'b1a2c3d4-e5f6-7890-ab12-cd34ef56ab78', '2025-10-01 14:30:00+00'),
       ('1d1c9e2a-7b4d-7a53-9c2e-8d6f5a1b2c3d', 'e3f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '0a1b2c3d-4e5f-6789-abcd-ef0123456789', '2025-10-01 16:45:00+00'),
       ('1e1c9e2a-7b4d-7a53-9c2e-8d6f5a1b2c3d', 'e3f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '0a1b2c3d-4e5f-6789-abcd-ef0123456789', '2025-10-01 19:15:00+01'),
       ('1f1c9e2a-7b4d-7a53-9c2e-8d6f5a1b2c3d', 'e3f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '0a1b2c3d-4e5f-6789-abcd-ef0123456789', '2025-10-01 21:45:00+00'),

-- Insert shows for Fifty Shades of Ehh
       ('3a7e6d4c-1a3f-4b2c-9d5e-6f7a8b9c0d1e', '23f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '123e4567-e89b-12d3-a456-426614174000', '2025-10-01 15:00:00+00'),
       ('3b7e6d4c-1a3f-4b2c-9d5e-6f7a8b9c0d1e', '23f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '123e4567-e89b-12d3-a456-426614174000', '2025-10-01 16:45:00+00'),

-- Insert shows for LORD OF THE REEEs
       ('3f1c9e2a-7b4d-4a53-9c2e-8d6f5a1b2c3d', 'ceb9370c-e8e9-423f-bce0-8d13322e55eb',
        'abcdefab-cdef-abcd-efab-cdefabcdefab', '2025-10-01 13:00:00+00'),
       ('6a2d4f9b-5c1e-4f3a-8b7d-9e0f1a2b3c4d', 'ceb9370c-e8e9-423f-bce0-8d13322e55eb',
        'abcdefab-cdef-abcd-efab-cdefabcdefab', '2025-10-01 15:30:00+00'),

-- Insert shows for Shrektok
       ('8c3d5b7a-2f1e-4c9b-8a6d-1b2c3d4e5f6a', '986ace32-7d3e-4cc7-ba5a-eec52b50a505',
        '123e4567-e89b-12d3-a456-426614174000', '2025-10-01 11:00:00+00'),
       ('9d4a7b6c-3e2f-4a1b-9c8d-7e6f5a4b3c2d', '986ace32-7d3e-4cc7-ba5a-eec52b50a505',
        '123e4567-e89b-12d3-a456-426614174000', '2025-10-01 13:00:00+00'),
       ('f1e2d3c4-b5a6-4f7e-8d9c-0a1b2c3d4e5f', '986ace32-7d3e-4cc7-ba5a-eec52b50a505',
        '0a1b2c3d-4e5f-6789-abcd-ef0123456789', '2025-10-01 09:45:00+00'),
       ('f2e2d3c4-b5a6-4f7e-8d9c-0a1b2c3d4e5f', '986ace32-7d3e-4cc7-ba5a-eec52b50a505',
        '0a1b2c3d-4e5f-6789-abcd-ef0123456789', '2025-10-01 11:45:00+00'),

-- Insert shows for Zoom High School Musical
       ('b3c4d5e6-f7a8-4b9c-8d1e-2f3a4b5c6d7e', 'e4f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'b1a2c3d4-e5f6-7890-ab12-cd34ef56ab78', '2025-10-01 17:00:00+00'),
       ('c4d5e6f7-a8b9-4c0d-8e2f-3a4b5c6d7e8f', 'e4f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'b1a2c3d4-e5f6-7890-ab12-cd34ef56ab78', '2025-10-01 19:00:00+00'),
       ('c5d5e6f7-a8b9-4c0d-8e2f-3a4b5c6d7e8f', 'e4f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'abcdefab-cdef-abcd-efab-cdefabcdefab', '2025-10-01 09:00:00+00'),
       ('c6d5e6f7-a8b9-4c0d-8e2f-3a4b5c6d7e8f', 'e4f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'abcdefab-cdef-abcd-efab-cdefabcdefab', '2025-10-01 11:00:00+00'),

-- Insert shows for Fast & Flurrious: Drifted in IKEA
       ('d5e6f7a8-b9c0-4d1e-8f3a-4b5c6d7e8f90', 'cab1370c-e8e9-423f-bce0-8d13322e55eb',
        'f7e6d5c4-b3a2-1908-7654-3210fedcba98', '2025-10-01 09:00:00+00'),
       ('e6f7a8b9-c0d1-4e2f-8a4b-5c6d7e8f901e', 'cab1370c-e8e9-423f-bce0-8d13322e55eb',
        'f7e6d5c4-b3a2-1908-7654-3210fedcba98', '2025-10-01 11:00:00+00'),
       ('f7a8b9c0-d1e2-4f3a-8b5c-6d7e8f901234', 'cab1370c-e8e9-423f-bce0-8d13322e55eb',
        'f7e6d5c4-b3a2-1908-7654-3210fedcba98', '2025-10-01 13:00:00+00'),
       ('01234567-89ab-4cde-8f01-23456789abcd', 'cab1370c-e8e9-423f-bce0-8d13322e55eb',
        'abcdefab-cdef-abcd-efab-cdefabcdefab', '2025-10-01 18:00:00+00'),

-- Insert shows for Among Us: The Movie (Sussy Edition)
       ('89abcdef-0123-4a56-8b8c-9d0e1f2a3b4c', 'e5f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '123e4567-e89b-12d3-a456-426614174000', '2025-10-01 09:00:00+00'),
       ('abcdef01-2345-4b67-8c9d-0e1f2a3b4c5d', 'e5f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '123e4567-e89b-12d3-a456-426614174000', '2025-10-01 18:30:00+00'),
       ('89bbcdef-0123-4a56-8b8c-9d0e1f2a3b4c', 'e5f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '9f8e7d6c-5b4a-3c2d-1e0f-9a8b7c6d5e4f', '2025-10-01 14:15:00+00'),
       ('abddef01-2345-4b67-8c9d-0e1f2a3b4c5d', 'e5f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '9f8e7d6c-5b4a-3c2d-1e0f-9a8b7c6d5e4f', '2025-10-01 16:00:00+00'),

-- Insert shows for Dune: Sand But Make It Fashion
       ('bcdef012-3456-4c78-9d0e-1f2a3b4c5d6e', 'a3f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'b1a2c3d4-e5f6-7890-ab12-cd34ef56ab78', '2025-10-01 21:00:00+00'),
       ('cdef0123-4567-4d89-8e1f-2a3b4c5d6e7f', 'a3f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'abcdefab-cdef-abcd-efab-cdefabcdefab', '2025-10-01 20:00:00+00')
ON CONFLICT (id) DO NOTHING;
-- Insert shows for The Chronicles of Naania
INSERT INTO shows (id, movie_id, theater_id, date)
VALUES ('3a2b3c4d-5a6f-7a8b-9c0d-1e2f3a4b5c2d', 'ceb9370c-e8e9-423f-bce0-8d13322e11eb',
        '9f8e7d6c-5b4a-3c2d-1e0f-9a8b7c6d5e4f', '2025-10-03 09:00:00+00'),
       ('4a2b3c4d-5b6f-7a8b-9c0d-1e2f3a4b5c3d', 'ceb9370c-e8e9-423f-bce0-8d13322e11eb',
        '9f8e7d6c-5b4a-3c2d-1e0f-9a8b7c6d5e4f', '2025-10-03 10:45:00+00'),
       ('5a2b3c4d-5c6f-7a8b-9c0d-1e2f3a4b5c4d', 'ceb9370c-e8e9-423f-bce0-8d13322e11eb',
        '9f8e7d6c-5b4a-3c2d-1e0f-9a8b7c6d5e4f', '2025-10-03 12:30:00+00'),
       ('6a2b3c4d-5d6f-7a8b-9c0d-1e2f3a4b5c5d', 'ceb9370c-e8e9-423f-bce0-8d13322e11eb',
        'f7e6d5c4-b3a2-1908-7654-3210fedcba98', '2025-10-03 16:00:00+00'),
       ('7a2b3c4d-5d6f-7b8b-9c0d-1e2f3a4b5c7d', 'ceb9370c-e8e9-423f-bce0-8d13322e11eb',
        'f7e6d5c4-b3a2-1908-7654-3210fedcba98', '2025-10-03 17:45:00+00'),
       ('8a2b3c4d-5d6f-7c8b-9c0d-1e2f3a4b5c8d', 'ceb9370c-e8e9-423f-bce0-8d13322e11eb',
        'f7e6d5c4-b3a2-1908-7654-3210fedcba98', '2025-10-03 19:00:00+00'),

-- Insert shows for The Bored of the Rings
       ('1a2c9e2a-7b4d-7a53-9c2e-8d6f5a1b2c4d', 'c4f3c041-8dd6-4197-8d56-8d6cb5e1496e',
        'b1a2c3d4-e5f6-7890-ab12-cd34ef56ab78', '2025-10-03 09:30:00+00'),
       ('1b3c9e2a-7b4d-7a53-9c2e-8d6f5a1b2c3e', 'c4f3c041-8dd6-4197-8d56-8d6cb5e1496e',
        'b1a2c3d4-e5f6-7890-ab12-cd34ef56ab78', '2025-10-03 12:00:00+00'),
       ('1c4c9e2a-7b4d-7a53-9c2e-8d6f5a1b2c3f', 'c4f3c041-8dd6-4197-8d56-8d6cb5e1496e',
        'b1a2c3d4-e5f6-7890-ab12-cd34ef56ab78', '2025-10-03 14:30:00+00'),
       ('1d5c9e2a-7b4d-7a53-9c2e-8d6f5a1b2c4a', 'c4f3c041-8dd6-4197-8d56-8d6cb5e1496e',
        '0a1b2c3d-4e5f-6789-abcd-ef0123456789', '2025-10-03 16:45:00+00'),
       ('1e6c9e2a-7b4d-7a53-9c2e-8d6f5a1b2c4b', 'c4f3c041-8dd6-4197-8d56-8d6cb5e1496e',
        '0a1b2c3d-4e5f-6789-abcd-ef0123456789', '2025-10-03 19:15:00+00'),
       ('1f7c9e2a-7b4d-7a53-9c2e-8d6f5a1b2c4c', 'c4f3c041-8dd6-4197-8d56-8d6cb5e1496e',
        '0a1b2c3d-4e5f-6789-abcd-ef0123456789', '2025-10-03 21:45:00+00'),

-- Insert shows for Slay Another Day
       ('3a7e6d4c-1a3f-4c2c-9d5e-6f7a8b9c0d1a', '13f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '123e4567-e89b-12d3-a456-426614174000', '2025-10-03 15:00:00+00'),
       ('3b7e6d4c-1a3f-4d2c-9d5e-6f7a8b9c0d1b', '13f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '123e4567-e89b-12d3-a456-426614174000', '2025-10-03 16:45:00+00'),

-- Insert shows for Yeet of the Jedi
       ('3f1c9e2a-7b4d-4a53-9c2e-1d6f5a1b3c3d', '33f3c041-8dd6-2199-8d56-5d6cb5e1496e',
        'abcdefab-cdef-abcd-efab-cdefabcdefab', '2025-10-03 13:00:00+00'),
       ('6a2d4f9b-5c1e-4f3a-8b7d-2e0f1a2b4c4d', '33f3c041-8dd6-2199-8d56-5d6cb5e1496e',
        'abcdefab-cdef-abcd-efab-cdefabcdefab', '2025-10-03 15:30:00+00'),

-- Insert shows for The Simping Dead
       ('8c3d5b7a-2f1e-4c9b-8a6d-5b2a3d4e5f6a', '43f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '123e4567-e89b-12d3-a456-426614174000', '2025-10-03 11:00:00+00'),
       ('9d4a7b6c-3e2f-4a1b-9c8d-6e6b5a4b3c2d', '43f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '123e4567-e89b-12d3-a456-426614174000', '2025-10-03 13:00:00+00'),
       ('f1e2d3c4-b5a6-4f7e-8d9c-9a1c2c3d4e5f', '43f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '0a1b2c3d-4e5f-6789-abcd-ef0123456789', '2025-10-03 09:45:00+00'),
       ('f2e2d3c4-b5a6-4f7e-8d9c-2a1d2c3d4e5f', '43f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '0a1b2c3d-4e5f-6789-abcd-ef0123456789', '2025-10-03 11:45:00+00'),

-- Insert shows for WAP: Wizards and Potions
       ('b3d4d5e6-f7a8-4b9c-8d1a-2f3a4b5c6d7e', '73f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'b1a2c3d4-e5f6-7890-ab12-cd34ef56ab78', '2025-10-03 17:00:00+00'),
       ('c4e5e6f7-a8b9-4c0d-8e2b-3a4b5c6d7e8f', '73f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'b1a2c3d4-e5f6-7890-ab12-cd34ef56ab78', '2025-10-03 19:00:00+00'),
       ('c5f5e6f7-a8b9-4c0d-8e2c-3a4b5c6d7e8f', '73f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'abcdefab-cdef-abcd-efab-cdefabcdefab', '2025-10-03 09:00:00+00'),
       ('c6a5e6f7-a8b9-4c01-8e2f-3a4b5c6d7e8f', '73f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'abcdefab-cdef-abcd-efab-cdefabcdefab', '2025-10-03 11:00:00+00'),

-- Insert shows for Ratatootie
       ('d516f7a8-b9c0-4d12-8f3a-4b5c6d7e8f90', 'd3f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'f7e6d5c4-b3a2-1908-7654-3210fedcba98', '2025-10-03 09:00:00+00'),
       ('e627a8b9-c0d1-4e23-8a4b-5c6d7e8f901e', 'd3f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'f7e6d5c4-b3a2-1908-7654-3210fedcba98', '2025-10-03 11:00:00+00'),
       ('f738b9c0-d1e2-4f34-8b5c-6d7e8f901234', 'd3f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'f7e6d5c4-b3a2-1908-7654-3210fedcba98', '2025-10-03 13:00:00+00'),
       ('01434567-89ab-4cd5-8f01-23456789abcd', 'd3f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'abcdefab-cdef-abcd-efab-cdefabcdefab', '2025-10-03 18:00:00+00'),

-- Insert shows for The Notebook.exe
       ('895bcdaf-0123-4a56-8b8c-9d0e1f2a3b4c', 'c3f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '123e4567-e89b-12d3-a456-426614174000', '2025-10-03 09:00:00+00'),
       ('ab6defb1-2345-4b67-8c9d-0e1f2a3b4c5d', 'c3f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '123e4567-e89b-12d3-a456-426614174000', '2025-10-03 18:30:00+00'),
       ('897bcdcf-0123-4a56-8b8c-9d0e1f2a3b4c', 'c3f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '9f8e7d6c-5b4a-3c2d-1e0f-9a8b7c6d5e4f', '2025-10-03 14:15:00+00'),
       ('ab8defd1-2345-4b67-8c9d-0e1f2a3b4c5d', 'c3f3c041-8dd6-4197-8d56-5d6cb5e1496e',
        '9f8e7d6c-5b4a-3c2d-1e0f-9a8b7c6d5e4f', '2025-10-03 16:00:00+00'),

-- Insert shows for The Grinch Who Stole My Vibe
       ('1cdef0e2-3456-4c78-9d0e-1f2a3b4c5d6e', 'caf3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'b1a2c3d4-e5f6-7890-ab12-cd34ef56ab78', '2025-10-03 21:00:00+00'),
       ('2def01f3-4567-4d89-8e1f-2a3b4c5d6e7f', 'caf3c041-8dd6-4197-8d56-5d6cb5e1496e',
        'abcdefab-cdef-abcd-efab-cdefabcdefab', '2025-10-03 20:00:00+00')
ON CONFLICT (id) DO NOTHING;