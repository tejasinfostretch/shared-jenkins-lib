const splunkjs = require("splunk-sdk");

const service = new splunkjs.Service({
  username: process.env.SPLUNK_USERNAME,
  password: process.env.SPLUNK_PASSWORD,
});

const getSplunkDataByQuery = (query, opts = {}) => {
  return new Promise((resolve, reject) => {
    service.oneshotSearch(
      query,
      { output_mode: "json", ...opts },
      function (err, jobs) {
        if (err) {
          reject(err);
        } else {
          resolve(jobs.results);
        }
      }
    );
  });
};

module.exports = {
  getSplunkDataByQuery: getSplunkDataByQuery,
};
