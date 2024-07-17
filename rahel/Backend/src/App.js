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

app.use('/stok', require('./api/rest/stok/Routes'));
app.use('/pengembalian', require('./api/rest/pengembalian/Routes'));
app.use('/pencatatan', require('./api/rest/pencatatan/Routes'));
app.use('/kategori', require('./api/rest/kategori/Routes'));
app.use('/petugas', require('./api/rest/petugas/Routes'));
app.use('/metodePembayaran', require('./api/rest/metodePembayaran/Routes'));
app.use('/lokasi', require('./api/rest/lokasi/Routes'));

app.use(NotFound);
app.use(Error);

module.exports = app;
