const shell = require("shelljs");
const common = require("./common");

console.log(common);

shell.exec("npm run build");

throw new Error("This custom error to fail jenkins build");
