const { insertLog } = require("../helper/dodLog.helper");

const init = async () => {
  const obj = {
    buildNumber: "#125",
    artifactName: "artifactName-splunk",
    dodStatus: "false",
    dodMessage: "This is Error From Splunk",
  };

  const result = await insertLog(obj);
  if (result) {
    console.log("Log is successfully logged..!");
  }
};

init();
