const Sequelize = require("sequelize");
const db = require("../db");

const Logs = db.define("Logs", {
  buildNumber: {
    type: Sequelize.STRING,
    allowNull: false,
  },
  artifactName: {
    type: Sequelize.STRING,
    allowNull: true,
  },
  dodStatus: {
    type: Sequelize.STRING,
    allowNull: true,
  },
  dodMessage: {
    type: Sequelize.STRING,
    allowNull: true,
  },
});

module.exports = Logs;
