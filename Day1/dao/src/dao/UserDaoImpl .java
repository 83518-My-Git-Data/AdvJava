public class UserDaoImpl implements UserDao {

    private final Connection connection;

    public UserDaoImpl(Connection connection) throws Exception {
        if (connection == null) {
            throw new IllegalArgumentException("Connection cannot be null");
        }
        this.connection = connection;
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public User findByEmail(String email) throws Exception {
        String sql = "SELECT * FROM users WHERE email = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return createUserFromResult(rs);
            }
            return null;
        }
    }

    @Override
    public User findById(int id) throws Exception {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return createUserFromResult(rs);
            }
            return null;
        }
    }

    @Override
    public int save(User user) throws Exception {
        String sql = "INSERT INTO users (first_name, last_name, email, password, dob, status, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, hashPassword(user.getPassword())); // Hash password before saving
            ps.setDate(5, new java.sql.Date(user.getDateOfBirth().getTime()));
            ps.setBoolean(6, user.getStatus());
            ps.setString(7, user.getRole());
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Failed to save user");
            }
        }
    }

    @Override
    public int updateStatus(int userId, boolean voted) throws Exception {
        String sql = "UPDATE users SET status = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setBoolean(1, voted);
            ps.setInt(2, userId);
            return ps.executeUpdate();
        }
    }

    @Override
    public int updatePassword(int userId, String newPassword) throws Exception {
        String sql = "UPDATE users SET password = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, hashPassword(newPassword)); // Hash new password before saving
            ps.setInt(2, userId);
            return ps.executeUpdate();
        }
    }

    @Override
    public int deleteById(int id) throws Exception {
        String sql = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(User user) throws Exception {
        String sql = "UPDATE users SET first_name = ?, last_name = ?, email = ?, dob = ?, status = ?, role = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setDate(4, new java.sql.Date(user.getDateOfBirth().getTime()));
            ps.setBoolean(5, user.getStatus());
            ps.setString(6, user.getRole());
            ps.setInt(7, user.getId());
            return ps.executeUpdate();
        }
    }
