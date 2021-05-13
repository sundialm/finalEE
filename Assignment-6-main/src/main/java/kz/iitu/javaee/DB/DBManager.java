package kz.iitu.javaee.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nurkz?useUnicode=true&characterEncoding=UTF8&serverTimezone=UTC", "root", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Language> allLanguages() {
        ArrayList<Language> languages = new ArrayList<Language>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM languages");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                languages.add(new Language(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("code")
                ));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return languages;
    }

    public static boolean addLanguage(Language language) {
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT into languages (id, name, code)" +
                    "VALUES (NULL , ?,?)");

            statement.setString(1, language.getName());
            statement.setString(2, language.getCode());


            rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return rows > 0;
    }

    public static boolean updateLanguage(Language language) {
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE languages SET name=?, code=?" +
                    "WHERE id =?");

            statement.setString(1, language.getName());
            statement.setString(2, language.getCode());
            statement.setLong(3, language.getId());

            rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return rows > 0;
    }

    public static boolean deleteLanguage(Long id) {
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM languages WHERE id = ?");

            statement.setLong(1, id);

            rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows > 0;

    }

    public static ArrayList<Publication> allPublications() {
        ArrayList<Publication> publications = new ArrayList<Publication>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM publications");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                publications.add(new Publication(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("rating")
                ));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return publications;
    }

    public static boolean addPublication(Publication publication) {
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT into publications (id, name, description, rating)" +
                    "VALUES (NULL , ?,?,?)");
            statement.setString(1, publication.getName());
            statement.setString(2, publication.getDescription());
            statement.setDouble(3, publication.getRating());
            rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows > 0;
    }

    public static boolean updatePublication(Publication publication) {
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE publications SET name=?, description=?, rating=?" +
                    "WHERE id =?");

            statement.setString(1, publication.getName());
            statement.setString(2, publication.getDescription());
            statement.setDouble(3, publication.getRating());
            statement.setLong(4, publication.getId());

            rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return rows > 0;
    }

    public static boolean deletePublication(Long id) {
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM publications WHERE id = ?");

            statement.setLong(1, id);

            rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows > 0;

    }

    public static Language getLanguageById(Long id) {
        Language language = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM languages " +
                    "WHERE id=?");

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                language = (new Language(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("code")
                ));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return language;
    }

    public static Publication getPublicationById(Long id) {
        Publication publication = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM publications " +
                    "WHERE id=?");

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                publication = (new Publication(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("rating")
                ));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return publication;
    }

    public static ArrayList<SongLyrics> allSongLyrics() {
        ArrayList<SongLyrics> songLyrics = new ArrayList<SongLyrics>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM songLyrics");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                songLyrics.add(new SongLyrics(
                        resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("short_content"),
                        resultSet.getString("content"),
                        resultSet.getTimestamp("post_date"),
                        resultSet.getString("picture_url"),
                        getLanguageById(resultSet.getLong("language_id")),
                        getPublicationById(resultSet.getLong("publication_id"))
                ));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return songLyrics;
    }

    public static ArrayList<SongLyrics> getSongsByPublicationId(Long id) {
        ArrayList<SongLyrics> songLyrics = new ArrayList<SongLyrics>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM songLyrics WHERE publication_id=?");

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                songLyrics.add(new SongLyrics(
                        resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("short_content"),
                        resultSet.getString("content"),
                        resultSet.getTimestamp("post_date"),
                        resultSet.getString("picture_url"),
                        getLanguageById(resultSet.getLong("language_id")),
                        getPublicationById(resultSet.getLong("publication_id"))
                ));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return songLyrics;
    }

}
