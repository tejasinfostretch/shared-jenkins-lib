const fs = require("fs");
const util = require("util");
const appendFile = util.promisify(fs.appendFile);

const logs = require("../database/models/logs.model");

const insertLog = (obj) => {
  return new Promise(async (resolve, reject) => {
    try {
      const result = await logs.build({ ...obj }).save();
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

const getLogs = () => {
  return logs.findAll();
};

const storeLogsInFile = (obj) => {
  let jsonString = JSON.stringify({ date: new Date(), ...obj });
  return appendFile("./logs.txt", jsonString + "\n");
};

module.exports = {
  insertLog: insertLog,
};
