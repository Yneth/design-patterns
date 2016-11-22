package ua.abond.pattern.flyweight;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class Recipe {
    private final String purpose;
    private final LocalDateTime assignDate;
    private final Duration duration;

    public Recipe(String purpose, LocalDateTime assignDate, Duration duration) {
        Objects.requireNonNull(purpose);
        Objects.requireNonNull(assignDate);
        Objects.requireNonNull(duration);

        this.purpose = purpose;
        this.assignDate = assignDate;
        this.duration = duration;
    }

    public String getPurpose() {
        return purpose;
    }

    public LocalDateTime getAssignDate() {
        return assignDate;
    }

    public Duration getDuration() {
        return duration;
    }

    public static class RecipeBuilder {
        String purpose;
        LocalDateTime assignDate;
        Duration duration;

        public RecipeBuilder() {
        }

        public RecipeBuilder setPurpose(String purpose) {
            this.purpose = purpose;
            return this;
        }

        public RecipeBuilder setAssignDate(LocalDateTime assignDate) {
            this.assignDate = assignDate;
            return this;
        }

        public RecipeBuilder setDuration(Duration duration) {
            this.duration = duration;
            return this;
        }

        public Recipe build() {
            return new Recipe(purpose, assignDate, duration);
        }
    }
}
