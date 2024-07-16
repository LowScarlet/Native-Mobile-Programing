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

app.use('/kategori', require('./api/rest/kategori/Routes'));
app.use('/penerbit', require('./api/rest/penerbit/Routes'));
app.use('/penulis', require('./api/rest/penulis/Routes'));

app.use('/buku', require('./api/rest/buku/Routes'));
app.use('/peminjaman', require('./api/rest/peminjaman/Routes'));

app.use(NotFound);
app.use(Error);

module.exports = app;
