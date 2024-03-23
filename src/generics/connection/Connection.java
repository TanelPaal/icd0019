package generics.connection;

import java.util.Objects;

public class Connection {
        private final String from;
        private final String to;

        public Connection(String from, String to) {
            if (from.equals(to)) {
                throw new IllegalArgumentException("'from' and 'to' can't be the same");
            }

            this.from = from;
            this.to = to;
        }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Connection other)) {
            return false;
        }

        return Objects.equals(from, other.from) &&
                Objects.equals(to, other.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", from, to);
    }
}
