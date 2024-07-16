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

app.use('/itemPesanan', require('./api/rest/itemPesanan/Routes'));
app.use('/konsumen', require('./api/rest/konsumen/Routes'));
app.use('/meja', require('./api/rest/meja/Routes'));
app.use('/menu', require('./api/rest/menu/Routes'));
app.use('/pesanan', require('./api/rest/pesanan/Routes'));
app.use('/reservasi', require('./api/rest/reservasi/Routes'));

app.use(NotFound);
app.use(Error);

module.exports = app;
