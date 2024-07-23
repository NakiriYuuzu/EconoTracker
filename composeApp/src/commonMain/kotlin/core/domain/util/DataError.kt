package core.domain.util

interface DataError: Error {
    enum class Network: DataError {

    }

    enum class Database: DataError {

    }

    enum class Local: DataError {
        UNKNOWN,
        DISK_FULL,
        FILE_NOT_FOUND
    }
}