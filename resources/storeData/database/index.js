const db = require("./db");
const dodTypes = require("./models/dodTypes.model");
const logs = require("./models/logs.model");

module.exports = {
  db: db,
  dodTypes: dodTypes,
  logs: logs,
};
