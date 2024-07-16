-- CreateTable
CREATE TABLE "Buku" (
    "id" SERIAL NOT NULL,
    "kode" TEXT NOT NULL,
    "judul" TEXT NOT NULL,
    "tahunTerbit" INTEGER NOT NULL,
    "halaman" INTEGER NOT NULL,
    "deskripsi" TEXT,
    "bahasa" TEXT NOT NULL,
    "penulisId" INTEGER,
    "kategoriId" INTEGER,
    "penerbitId" INTEGER,

    CONSTRAINT "Buku_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "Penulis" (
    "id" SERIAL NOT NULL,
    "kode" TEXT NOT NULL,
    "nama" TEXT NOT NULL,
    "tanggalLahir" TEXT NOT NULL,
    "biografi" TEXT,
    "kewarganegaraan" TEXT NOT NULL,
    "penghargaan" TEXT,

    CONSTRAINT "Penulis_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "Kategori" (
    "id" SERIAL NOT NULL,
    "kode" TEXT NOT NULL,
    "nama" TEXT NOT NULL,
    "deskripsi" TEXT,

    CONSTRAINT "Kategori_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "Peminjaman" (
    "id" SERIAL NOT NULL,
    "tanggalPinjam" TEXT NOT NULL DEFAULT '',
    "tanggalKembali" TEXT,
    "tanggalJatuhTempo" TEXT NOT NULL,
    "status" TEXT NOT NULL,
    "denda" DOUBLE PRECISION NOT NULL DEFAULT 0.0,
    "bukuId" INTEGER NOT NULL,

    CONSTRAINT "Peminjaman_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "Penerbit" (
    "id" SERIAL NOT NULL,
    "kode" TEXT NOT NULL,
    "nama" TEXT NOT NULL,
    "lokasi" TEXT NOT NULL,
    "tahunBerdiri" INTEGER NOT NULL,
    "emailKontak" TEXT NOT NULL,
    "nomorTelepon" TEXT NOT NULL,

    CONSTRAINT "Penerbit_pkey" PRIMARY KEY ("id")
);

-- CreateIndex
CREATE UNIQUE INDEX "Buku_kode_key" ON "Buku"("kode");

-- CreateIndex
CREATE UNIQUE INDEX "Penulis_kode_key" ON "Penulis"("kode");

-- CreateIndex
CREATE UNIQUE INDEX "Penulis_nama_key" ON "Penulis"("nama");

-- CreateIndex
CREATE UNIQUE INDEX "Kategori_kode_key" ON "Kategori"("kode");

-- CreateIndex
CREATE UNIQUE INDEX "Kategori_nama_key" ON "Kategori"("nama");

-- CreateIndex
CREATE UNIQUE INDEX "Penerbit_kode_key" ON "Penerbit"("kode");

-- CreateIndex
CREATE UNIQUE INDEX "Penerbit_nama_key" ON "Penerbit"("nama");

-- AddForeignKey
ALTER TABLE "Buku" ADD CONSTRAINT "Buku_penulisId_fkey" FOREIGN KEY ("penulisId") REFERENCES "Penulis"("id") ON DELETE SET NULL ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "Buku" ADD CONSTRAINT "Buku_kategoriId_fkey" FOREIGN KEY ("kategoriId") REFERENCES "Kategori"("id") ON DELETE SET NULL ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "Buku" ADD CONSTRAINT "Buku_penerbitId_fkey" FOREIGN KEY ("penerbitId") REFERENCES "Penerbit"("id") ON DELETE SET NULL ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "Peminjaman" ADD CONSTRAINT "Peminjaman_bukuId_fkey" FOREIGN KEY ("bukuId") REFERENCES "Buku"("id") ON DELETE CASCADE ON UPDATE CASCADE;
