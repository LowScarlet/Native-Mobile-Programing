-- CreateTable
CREATE TABLE "Stok" (
    "id" SERIAL NOT NULL,
    "jumlah" INTEGER NOT NULL,
    "kategoriId" INTEGER,

    CONSTRAINT "Stok_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "Pengembalian" (
    "id" SERIAL NOT NULL,
    "waktuPengembalian" TEXT NOT NULL,
    "harga" DOUBLE PRECISION NOT NULL,
    "pencatatanId" INTEGER,
    "stokId" INTEGER,
    "metodePembayaranId" INTEGER,
    "petugasId" INTEGER,

    CONSTRAINT "Pengembalian_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "Pencatatan" (
    "id" SERIAL NOT NULL,
    "nama" TEXT NOT NULL,
    "nomorHp" TEXT NOT NULL,
    "jumlah" INTEGER NOT NULL,
    "mulaiSewa" TEXT NOT NULL,
    "petugasId" INTEGER,
    "lokasiId" INTEGER,
    "stokId" INTEGER,

    CONSTRAINT "Pencatatan_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "Kategori" (
    "id" SERIAL NOT NULL,
    "nama" TEXT NOT NULL,
    "kapasitas" INTEGER NOT NULL,

    CONSTRAINT "Kategori_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "Petugas" (
    "id" SERIAL NOT NULL,
    "nama" TEXT NOT NULL,
    "alamat" TEXT NOT NULL,
    "nomorHp" TEXT NOT NULL,

    CONSTRAINT "Petugas_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "MetodePembayaran" (
    "id" SERIAL NOT NULL,
    "tipe" TEXT NOT NULL,
    "keterangan" TEXT NOT NULL,

    CONSTRAINT "MetodePembayaran_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "Lokasi" (
    "id" SERIAL NOT NULL,
    "nama" TEXT NOT NULL,
    "alamat" TEXT NOT NULL,

    CONSTRAINT "Lokasi_pkey" PRIMARY KEY ("id")
);

-- AddForeignKey
ALTER TABLE "Stok" ADD CONSTRAINT "Stok_kategoriId_fkey" FOREIGN KEY ("kategoriId") REFERENCES "Kategori"("id") ON DELETE SET NULL ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "Pengembalian" ADD CONSTRAINT "Pengembalian_pencatatanId_fkey" FOREIGN KEY ("pencatatanId") REFERENCES "Pencatatan"("id") ON DELETE SET NULL ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "Pengembalian" ADD CONSTRAINT "Pengembalian_stokId_fkey" FOREIGN KEY ("stokId") REFERENCES "Stok"("id") ON DELETE SET NULL ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "Pengembalian" ADD CONSTRAINT "Pengembalian_metodePembayaranId_fkey" FOREIGN KEY ("metodePembayaranId") REFERENCES "MetodePembayaran"("id") ON DELETE SET NULL ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "Pengembalian" ADD CONSTRAINT "Pengembalian_petugasId_fkey" FOREIGN KEY ("petugasId") REFERENCES "Petugas"("id") ON DELETE SET NULL ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "Pencatatan" ADD CONSTRAINT "Pencatatan_petugasId_fkey" FOREIGN KEY ("petugasId") REFERENCES "Petugas"("id") ON DELETE SET NULL ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "Pencatatan" ADD CONSTRAINT "Pencatatan_lokasiId_fkey" FOREIGN KEY ("lokasiId") REFERENCES "Lokasi"("id") ON DELETE SET NULL ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "Pencatatan" ADD CONSTRAINT "Pencatatan_stokId_fkey" FOREIGN KEY ("stokId") REFERENCES "Stok"("id") ON DELETE SET NULL ON UPDATE CASCADE;
