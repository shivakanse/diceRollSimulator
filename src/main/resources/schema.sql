DROP TABLE IF EXISTS Dice;

CREATE TABLE Dice (
  id LONG AUTO_INCREMENT  PRIMARY KEY,
  number_of_dice INT NOT NULL,
  number_of_sides INT NOT NULL,
  number_of_rolls INT NOT NULL,
  dice_distribution CLOB
);