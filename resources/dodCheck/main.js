const { insertLog } = require("./helper/dodLog.helper");
const { getSplunkDataByQuery } = require("./helper/splunk.helper");

const init = async () => {
  const obj = {
    buildNumber: "#125",
    artifactName: "name-test",
    dodStatus: "false",
    dodMessage: "This is Error",
  };

  const result = await insertLog(obj);
  if (result) {
    console.log("Log is successfully logged..!");
  }
};

const initSplunk = async () => {
  try {
    const query = `search source="main-vamshi.log"  host = ICPL13950 sourcetype="electorn-logs" | stats count by sourcetype`;
    const result = await getSplunkDataByQuery(query);
    console.log(result);
  } catch (e) {
    console.log(e);
  }
};

init();
