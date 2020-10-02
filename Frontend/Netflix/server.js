//Install express server
const express = require('express');
const path = require('path');

const app = express();

// Serve only the static files form the dist directory
app.use(express.static(__dirname + '/dist/Netflix'));

app.get('/*', function(req,res) {
    
res.sendFile(path.join(__dirname+'/dist/Netflix/index.html'));
});

// Start the app by listening on the default Heroku port
app.listen(process.env.PORT || 4200);


// This is for server deployment! Enable this in package.json --> "start": "node server.js",

