package mobcom.ilkom.unsri.unsriguidemap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Hasby on 05/12/2015.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "ugm";
    private static final String TABLE_NAME = "description";
    private static final String FIELD_ID = "id";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_DESCRIPTION = "description";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME +" ("
                + FIELD_ID +" VARCHAR(50), "
                + FIELD_NAME +" VARCHAR(100), "
                + FIELD_DESCRIPTION +" VARCHAR(10) );";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop tabel lama jika sudah ada
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // Create tables again
        onCreate(db);
    }

    public String getCompanyIdByToken(String token) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from "+ TABLE_NAME +" where "+ FIELD_ID +" = '" + token +"';", null);
        if (cursor != null) {
            cursor.moveToFirst();
            return cursor.getString(2);
        }
        else {
            return "no data";
        }
    }

    // Menambahkan data Fakultas
    public void addData(String data) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        int i = 0;
        while(i != 10) {
            values.put(FIELD_ID, i);

            if(i == 0){
                values.put(FIELD_NAME, "Fakultas Kesehatan Masyarakat");
                values.put(FIELD_DESCRIPTION, "Fakultas Kesehatan Masyarakat dibuka pada tanggal 18 Agustus 2000,\n" +
                        "dimana sebelumnya merupakan salah satu program studi di Fakultas Kedokteran.\n" +
                        "Visi FKM adalah Menjadi fakultas terkemuka berbasis riset yang unggul \n" +
                        "dalam ilmu pengetahuan, teknologi dan seni di bidang kesehatan masyarakat, \n" +
                        "yang menghasilkan insan bertaqwa, bermutu dan memiliki daya saing tinggi.\n" +
                        "\n" +
                        "Jurusan :\n" +
                        "Bagian Administrasi Kebijakan Kesehatan (AKK)\n" +
                        "Bagian Gizi Masyarakat\n" +
                        "Bagian Keselamatan kesehatan Kerja dan Kesehatan Lingkungan");
            }
            else if(i == 1){
                values.put(FIELD_NAME, "Fakultas Kedokteran");
                values.put(FIELD_DESCRIPTION, "Fakultas Kedokteran Universitas Sriwijaya dibuka pada tanggal 1 Agustus 1962.\n" +
                        "Pengembangan dan pembinaan pendidikan dokter di FK Unsri berorientasi kepada \n" +
                        "ilmu pengetahuan dan teknologi kedokteran serta masyarakat.\n" +
                        "\n" +
                        "Program Pendidikan :\n" +
                        "Program Studi Pendidikan Dokter - S1\n" +
                        "Program Studi Ilmu Keperawatan - S1\n" +
                        "Program Studi Ilmu Kesehatan Masyarakat - S1\n" +
                        "Program Studi Kedokteran Gigi - S1\n" +
                        "Program Studi Teknik Gigi - D3 ");
            }
            else if(i == 2){
                values.put(FIELD_NAME, "Fakultas Teknik");
                values.put(FIELD_DESCRIPTION, "Fakultas Teknik didirikan pada tanggal 1 Oktober 1960.\n" +
                        "Visi dari Fakultas Teknik Universitas Sriwijaya adalah  untuk menjadi fakultas\n" +
                        "berbasis RIPTEKS (Riset, Ilmu Pengetahuan, Teknologi, dan Sains) dan mampu\n" +
                        "berkompetisi di era global.\n" +
                        "\n" +
                        "Program Pendidikan :\n" +
                        "    Program Studi Teknik Sipil\n" +
                        "    Program Studi Teknik Pertambangan\n" +
                        "    Program Studi Teknik Mesin\n" +
                        "    Program Studi Teknik Kimia \n" +
                        "    Program Studi Teknik Elektro\n" +
                        "    Program Studi Teknik Arsitektur\n" +
                        "    Program Studi Teknik Geologi");
            }
            else if(i == 3){
                values.put(FIELD_NAME, "Fakultas Matematika dan Ilmu Pengetahuan Alam");
                values.put(FIELD_DESCRIPTION, "Fakultas MIPA pada awal berdirinya bernaung di bawah Fakultas Teknik \n" +
                        "dengan nama program studi MIPA (PS-MIPA) yang berdiri pada tanggal 6 Maret 1989\n" +
                        "Menjadikan Fakultas MIPA sebagai fakultas terkemuka berbasis riset \n" +
                        "yang unggul dalam sains dan teknologi pada tahun 2025. \n" +
                        "\n" +
                        "\n" +
                        "Program Pendidikan :\n" +
                        "    Program Studi Matematika (S1)\n" +
                        "    Program Studi Fisika (S1)\n" +
                        "    Program Studi Kimia (S1)\n" +
                        "    Program Studi Biologi (S1)\n" +
                        "    Program Studi Ilmu Kelautan (S1)");
            }
            else if(i == 4){
                values.put(FIELD_NAME, "Fakultas Pertanian");
                values.put(FIELD_DESCRIPTION, "Fakultas Pertanian Universitas Sriwijaya berhasil didirikan \n" +
                        "tanggal 20 September 1963.\n" +
                        "\n" +
                        "Program Studi S1 :\n" +
                        "Agronomi\n" +
                        "Tanah\n" +
                        "Agribisnis\n" +
                        "Ilmu Hama dan Penyakit Tumbuhan\n" +
                        "Teknik Pertanian\n" +
                        "Teknologi Hasil Pertanian\n" +
                        "Peternakan\n" +
                        "Budidaya Perairan\n" +
                        "Teknologi Hasil Perikanan\n" +
                        "Agroekoteknologi");
            }
            else if(i == 5){
                values.put(FIELD_NAME, "Fakultas Keguruan dan Ilmu Kependidikan");
                values.put(FIELD_DESCRIPTION, "Fakultas Keguruan dan Ilmu Kependidikan didirikian pada tanggal 13 Juni 1961.\n" +
                        "Memiliki Visi \"Pada Dasawarsa Kedua Abad Ke-21 Merupakan Lembaga yang Unggul\n" +
                        "dalam pengembangan SDM, Riset, Informasi, dan Inovasi Kependidikan.\n" +
                        "\n" +
                        "Program Pendidikan:\n" +
                        "    Program Studi Pendidikan Bahasa Inggris (S1)\n" +
                        "    Program Studi Pendidikan Bahasa Indonesia, Sastra Indonesia dan Daerah (S1)\n" +
                        "    Program Studi Pendidikan Pancasila & Kewarganegaraan (S1)\n" +
                        "    Program Studi Pendidikan Sejarah (S1)\n" +
                        "    Program Studi Pendidikan Ekonomi Akuntansi (S1)\n" +
                        "    Program Studi Pendidikan Matematika (S1)\n" +
                        "    Program Studi Pendidikan Biologi (S1)\n" +
                        "    Program Studi Pendidikan Kimia (S1)\n" +
                        "    Program Studi Pendidikan Fisika (S1)\n" +
                        "    Program Studi Pendidikan Teknik Mesin (S1)\n" +
                        "    Program Studi Pendidikan Jasmani dan Kesehatan (S1)\n" +
                        "    Program Studi Pendidikan Guru Sekolah Dasar (S1) \n" +
                        "    Program Studi Pendidikan Anak Usia Dini (S1)\n" +
                        "    Program Studi Pendidikan Bimbingan & Konseling(S1)");
            }
            else if(i == 6){
                values.put(FIELD_NAME, "Fakultas Ilmu Komputer");
                values.put(FIELD_DESCRIPTION, "Berdirinya Fakultas Ilmu Komputer didahului dengan \n" +
                        "Program Diploma Komputer (PDK) Unsri baru berdiri pertengahan tahun 2003, \n" +
                        "tepatnya tanggal 5 September 2003 dan merupakan program pendidikan \n" +
                        "bidang ICT yang pertama di Universitas Sriwijaya\n" +
                        "\n" +
                        "Jurusan :\n" +
                        "1. Teknik Informatika\n" +
                        "2. Sistem Komputer\n" +
                        "3. Sistem Informasi");
            }
            else if(i == 7){
                values.put(FIELD_NAME, "Fakultas Ekonomi");
                values.put(FIELD_DESCRIPTION, "Fakultas Ekonomi didirikan tanggal 31 Oktober 1953. Visi Fakultas Ekonomi \n" +
                        "Universitas Sriwijaya adalah menjadi Fakultas Ekonomi yang terkemuka \n" +
                        "di kawasan ASEAN pada dasawarsa kedua abad ke-21.\n" +
                        "\n" +
                        "Program Pendidikan :\n" +
                        "1. Jurusan Manajemen (S1)\n" +
                        "2. Jurusan Ekonomi Pembangunan (S1)\n" +
                        "3. Jurusan Akuntansi (S1)\n" +
                        "4. Kesekretariatan (D3)\n" +
                        "5. Akuntansi (D3)");
            }
            else if(i == 8){
                values.put(FIELD_NAME, "Fakultas Ilmu Sosial dan Politik");
                values.put(FIELD_DESCRIPTION, "Fakultas Ilmu Sosial dan Ilmu Politik didirikan pada tanggal 12 Februari 1983.\n" +
                        "FISIP memiliki visi \"Menjadi fakultas yang unggul dan berbasis riset, \n" +
                        "yang memiliki keunggulan kompetitif dalam bidang ilmu sosial, \n" +
                        "budaya dan politik tahun 2025.\"\n" +
                        "\n" +
                        "Program Pendidikan :\n" +
                        "    Program Studi Ilmu Administrasi Negara - S1\n" +
                        "    Program Studi Sosiologi - S1\n" +
                        "    Program Studi Ilmu Komunikasi - S1");
            }
            else if(i == 9){
                values.put(FIELD_NAME, "Fakultas Hukum");
                values.put(FIELD_DESCRIPTION, "Fakultas Hukum didirikan pada tanggal 31 Oktober 1957.\n" +
                        "Pada saat ini Fakultas Hukum UNSRI memiliki satu Program Studi yaitu \n" +
                        "Program Studi Ilmu Hukum dengan lima (5) Program Kekhususan (PK) yaitu \n" +
                        "PK Studi Hukum dan Sistem Peradilan, PK Studi Hukum dan Bisnis, \n" +
                        "PK Studi Hukum dan KeIslaman, PK Studi Hukum dan Kenegaraan dan \n" +
                        "PK Studi Hukum dan Masalah-masalah Transasional.\n" +
                        "\n" +
                        "Program Pendidikan :\n" +
                        "Jurusan Ilmu Hukum (S1)");
            }

                // memasukkan data
            db.insert(TABLE_NAME, null, values);
            i++;
        }
        db.close(); // Menutup koneksi database
    }
}
