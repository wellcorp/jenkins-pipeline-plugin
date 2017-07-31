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
