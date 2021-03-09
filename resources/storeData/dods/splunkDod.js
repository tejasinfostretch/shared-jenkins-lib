const { getSplunkDataByQuery } = require("./helper/splunk.helper");

const initSplunk = async () => {
  try {
    const query = `search source="main-vamshi.log"  host = ICPL13950 sourcetype="electorn-logs" | stats count by sourcetype`;
    const result = await getSplunkDataByQuery(query);
    console.log(result);
  } catch (e) {
    console.log(e);
  }
};

initSplunk();
