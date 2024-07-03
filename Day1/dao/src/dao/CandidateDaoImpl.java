import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CandidateDaoImpl implements CandidateDao {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/electiondb"; 
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "manager";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    @Override
    public void close() throws Exception {
        Connection connection = getConnection();
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public List<Candidate> findAll() throws Exception {
        List<Candidate> candidates = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM candidates");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            candidates.add(mapRowToCandidate(rs));
        }
        rs.close();
        stmt.close();
        connection.close();
        return candidates;
    }

    @Override
    public List<Candidate> findByParty(String party) throws Exception {
        List<Candidate> candidates = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM candidates WHERE party = ?");
        stmt.setString(1, party);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            candidates.add(mapRowToCandidate(rs));
        }
        rs.close();
        stmt.close();
        connection.close();
        return candidates;
    }

    @Override
    public List<Candidate> findAllOrderByVotesDesc() throws Exception {
        List<Candidate> candidates = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM candidates ORDER BY votes DESC");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            candidates.add(mapRowToCandidate(rs));
        }
        rs.close();
        stmt.close();
        connection.close();
        return candidates;
    }

    @Override
    public int save(Candidate c) throws Exception {
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO candidates (name, party, votes) VALUES (?, ?, ?)");
        stmt.setString(1, c.getName());
        stmt.setString(2, c.getParty());
        stmt.setInt(3, c.getVotes());
        int rowsAffected = stmt.executeUpdate();
        stmt.close();
        connection.close();
        return rowsAffected;
    }

    @Override
    public int deleteById(int id) throws Exception {
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM candidates WHERE id = ?");
        stmt.setInt(1, id);
        int rowsAffected = stmt.executeUpdate();
        stmt.close();
        connection.close();
        return rowsAffected;
    }

    @Override
    public int update(Candidate c) throws Exception {
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement("UPDATE candidates SET name = ?, party = ?, votes = ? WHERE id = ?");
        stmt.setString(1, c.getName());
        stmt.setString(2, c.getParty());
        stmt.setInt(3, c.getVotes());
        stmt.setInt(4, c.getId());
        int rowsAffected = stmt.executeUpdate();
        stmt.close();
        connection.close();
        return rowsAffected;
    }

    @Override
    public Candidate findById(int id) throws Exception {
        Candidate candidate = null;
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM candidates WHERE id = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            candidate = mapRowToCandidate(rs);
