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

app.use('/barang', require('./api/rest/barang/Routes'));
app.use('/kategoriBarang', require('./api/rest/kategoriBarang/Routes'));
app.use('/laporanKehilangan', require('./api/rest/laporanKehilangan/Routes'));
app.use('/laporanPenemuan', require('./api/rest/laporanPenemuan/Routes'));
app.use('/lokasi', require('./api/rest/lokasi/Routes'));
app.use('/pelapor', require('./api/rest/pelapor/Routes'));

app.use(NotFound);
app.use(Error);

module.exports = app;
