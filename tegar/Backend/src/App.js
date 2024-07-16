const express = require('express');
const NotFound = require('./api/utils/NotFound');
const Error = require('./api/utils/Error');

const app = express();

// Default Configuration
app.set('json spaces', 2);
app.use(express.json({ limit: '50mb' }));
app.use(express.urlencoded({ extended: true, limit: '50mb' }));

app.get('/', (req, res) => {
  res.json({
    message: 'Welcome to the Portfolio API'
  });
});

app.use((req, res, next) => {
  req.scarlet = {
    params: {},
    query: {},
    body: {},
  };
  next();
});

app.use('/portfolio', require('./api/rest/portfolio/Routes'));

app.use('/portfolioDetail', require('./api/rest/portfolioDetail/Routes'));
app.use('/portfolioEducation', require('./api/rest/portfolioEducation/Routes'));
app.use('/portfolioProject', require('./api/rest/portfolioProject/Routes'));
app.use('/portfolioWork', require('./api/rest/portfolioWork/Routes'));

app.use('/company', require('./api/rest/company/Routes'));
app.use('/department', require('./api/rest/department/Routes'));
app.use('/institution', require('./api/rest/institution/Routes'));

app.use(NotFound);
app.use(Error);

module.exports = app;
