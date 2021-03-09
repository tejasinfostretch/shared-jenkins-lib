const { insertLog } = require("../helper/dodLog.helper");

const init = async () => {
  const obj = {
    buildNumber: "#125",
    artifactName: "artifactName",
    dodStatus: "false",
    dodMessage: "This is Error From qTest",
  };

  const result = await insertLog(obj);
  if (result) {
    console.log("Log is successfully logged..!");
  }
};
