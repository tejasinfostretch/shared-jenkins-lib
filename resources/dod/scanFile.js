const shell = require("shelljs");
const common = require("./common");

console.log(common);

shell.exec("npm run build");
