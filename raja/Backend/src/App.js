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

app.use('/karyawan', require('./api/rest/karyawan/Routes'));
app.use('/pelanggan', require('./api/rest/pelanggan/Routes'));
app.use('/pemasok', require('./api/rest/pemasok/Routes'));
app.use('/pemesanan', require('./api/rest/pemesanan/Routes'));
app.use('/pengantaran', require('./api/rest/pengantaran/Routes'));
app.use('/galon', require('./api/rest/galon/Routes'));

app.use(NotFound);
app.use(Error);

module.exports = app;
