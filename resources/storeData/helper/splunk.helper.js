const splunkjs = require("splunk-sdk");
require("dotenv").config();

const service = new splunkjs.Service({
  username: process.env.SPLUNK_USERNAME,
  password: process.env.SPLUNK_PASSWORD,
});

const getSplunkDataByQuery = (query) => {
  return new Promise((resolve, reject) => {
    service.oneshotSearch(query, { output_mode: "json" }, function (err, jobs) {
      if (err) {
        reject(err);
      } else {
        resolve(jobs.results);
      }
    });
  });
};

module.exports = {
  getSplunkDataByQuery: getSplunkDataByQuery,
};
