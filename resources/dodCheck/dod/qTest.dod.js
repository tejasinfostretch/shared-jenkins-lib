const { insertLog } = require("../helper/dodLog.helper");

const init = async () => {
  console.log(process.argv[2]);
  var correctJson = process.argv[2].replace(
    /(['"])?([a-z0-9A-Z_]+)(['"])?:/g,
    '"$2": '
  );
  console.log(JSON.parse(correctJson));
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

init();
