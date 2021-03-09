const Sequelize = require("sequelize");
require("dotenv").config();

const fs = require("fs");
const util = require("util");
const appendFile = util.promisify(fs.appendFile);

const db = new Sequelize(
  process.env.DB_SCHEMA || "postgres",
  process.env.DB_USER || "postgres",
  process.env.DB_PASSWORD || "postgres",
  {
    host: process.env.DB_HOST || "localhost",
    port: process.env.DB_PORT || 5432,
    dialect: "postgres",
    dialectOptions: {
      ssl: process.env.DB_SSL == "true",
    },
  }
);

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

const insertLog = (obj) => {
  return new Promise(async (resolve, reject) => {
    try {
      const result = await Logs.build({ ...obj }).save();
      if (result) {
        resolve(result);
      }
    } catch (e) {
      console.log("Error Occurred in storing log into database ", e.message);
      console.log("Storing log into log file ");
      await storeLogsInFile(obj);
      resolve(true);
    }
  });
};

const storeLogsInFile = (obj) => {
  let jsonString = JSON.stringify({ date: new Date(), ...obj });
  return appendFile("./logs.txt", jsonString + "\n");
};

module.exports = {
  insertLog: insertLog,
};
