const Sequelize = require("sequelize");
const db = require("../db");

const dodTypes = db.define("dodTypes", {
  dodType: {
    type: Sequelize.STRING,
    allowNull: false,
  },
  dodName: {
    type: Sequelize.STRING,
    allowNull: true,
  },
  dodDescription: {
    type: Sequelize.STRING,
    allowNull: true,
  },
});

module.exports = dodTypes;
