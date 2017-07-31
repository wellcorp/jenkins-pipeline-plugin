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

        stage("Deploy Canary") {
            print("Deploying Canary")
        }

        stage("Test Canary") {
            print("Testing Canary")
        }

        stage("Human Testing") {
            input(message: 'Manual testing succeeded?', ok: 'Yes')
        }

        stage("Deploy Production") {
            print("Deploying Production")
        }
    }
}
