-- CreateTable
CREATE TABLE "Pelapor" (
    "id" SERIAL NOT NULL,
    "email" TEXT NOT NULL,
    "nama" TEXT NOT NULL,
    "telepon" TEXT NOT NULL,

    CONSTRAINT "Pelapor_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "Barang" (
    "id" SERIAL NOT NULL,
    "nama" TEXT NOT NULL,
    "deskripsi" TEXT NOT NULL,
    "kategoriId" INTEGER NOT NULL,
    "lokasiId" INTEGER NOT NULL,

    CONSTRAINT "Barang_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "KategoriBarang" (
    "id" SERIAL NOT NULL,
    "nama" TEXT NOT NULL,

    CONSTRAINT "KategoriBarang_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "Lokasi" (
    "id" SERIAL NOT NULL,
    "nama" TEXT NOT NULL,
    "alamat" TEXT NOT NULL,

    CONSTRAINT "Lokasi_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "LaporanKehilangan" (
    "id" SERIAL NOT NULL,
    "tanggal" TEXT NOT NULL,
    "barangId" INTEGER NOT NULL,
    "pelaporId" INTEGER NOT NULL,

    CONSTRAINT "LaporanKehilangan_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "LaporanPenemuan" (
    "id" SERIAL NOT NULL,
    "tanggal" TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "barangId" INTEGER NOT NULL,
    "pelaporId" INTEGER NOT NULL,

    CONSTRAINT "LaporanPenemuan_pkey" PRIMARY KEY ("id")
);

-- CreateIndex
CREATE UNIQUE INDEX "Pelapor_email_key" ON "Pelapor"("email");

-- AddForeignKey
ALTER TABLE "Barang" ADD CONSTRAINT "Barang_kategoriId_fkey" FOREIGN KEY ("kategoriId") REFERENCES "KategoriBarang"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "Barang" ADD CONSTRAINT "Barang_lokasiId_fkey" FOREIGN KEY ("lokasiId") REFERENCES "Lokasi"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "LaporanKehilangan" ADD CONSTRAINT "LaporanKehilangan_barangId_fkey" FOREIGN KEY ("barangId") REFERENCES "Barang"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "LaporanKehilangan" ADD CONSTRAINT "LaporanKehilangan_pelaporId_fkey" FOREIGN KEY ("pelaporId") REFERENCES "Pelapor"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "LaporanPenemuan" ADD CONSTRAINT "LaporanPenemuan_barangId_fkey" FOREIGN KEY ("barangId") REFERENCES "Barang"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "LaporanPenemuan" ADD CONSTRAINT "LaporanPenemuan_pelaporId_fkey" FOREIGN KEY ("pelaporId") REFERENCES "Pelapor"("id") ON DELETE RESTRICT ON UPDATE CASCADE;
