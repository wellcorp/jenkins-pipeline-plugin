def call(body) {
    // evaluate the body block, and collect configuration into the object
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    // now build, based on the configuration provided
    node {
        stage("Build") {
            print("Building")
        }

        stage("Test") {
            print("Testing")
        }

        stage("Publish") {
            print("Deploying Canary")
        }
    }
}
